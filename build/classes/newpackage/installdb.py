# import pyodbc

# db_path = r"E:\doc\HeroGymLastEdition\src\newpackage\New_Microsoft_Access_Database.accdb"

# conn = pyodbc.connect(
#     rf"DRIVER={{Microsoft Access Driver (*.mdb, *.accdb)}};DBQ={db_path};"
# )

# cursor = conn.cursor()

# tables = []

# for row in cursor.tables(tableType='TABLE'):
#     tables.append(row.table_name)

# with open("schema.sql", "w", encoding="utf-8") as f:

#     for table in tables:

#         columns = cursor.columns(table=table)

#         col_defs = []

#         for col in columns:

#             name = col.column_name
#             datatype = col.type_name

#             # map Access types to SQL
#             sql_type = {
#                 "VARCHAR": "TEXT",
#                 "LONGCHAR": "TEXT",
#                 "INTEGER": "INT",
#                 "LONG": "BIGINT",
#                 "DOUBLE": "DOUBLE",
#                 "DATETIME": "DATETIME",
#                 "BIT": "BOOLEAN",
#             }.get(datatype, "TEXT")

#             col_defs.append(f"    [{name}] {sql_type}")

#         create_sql = f"CREATE TABLE [{table}] (\n"
#         create_sql += ",\n".join(col_defs)
#         create_sql += "\n);\n\n"

#         f.write(create_sql)

# print("Schema exported to schema.sql")
import pyodbc

db_path = r"E:\doc\HeroGymLastEdition\src\newpackage\New_Microsoft_Access_Database.accdb"

conn = pyodbc.connect(
    rf"DRIVER={{Microsoft Access Driver (*.mdb, *.accdb)}};DBQ={db_path};"
)

cursor = conn.cursor()

tables = []

# get tables
for row in cursor.tables(tableType='TABLE'):

    table_name = row.table_name

    if not table_name.startswith("MSys"):
        tables.append(table_name)

# get primary keys manually
primary_keys = {}

try:
    pk_query = """
    SELECT
        Name,
        ForeignName
    FROM MSysObjects
    WHERE Type = 1
    """

    rows = cursor.execute(pk_query).fetchall()

except:
    rows = []

with open("schema.sql", "w", encoding="utf-8") as f:

    for table in tables:

        f.write(f"-- TABLE: {table}\n")

        columns = cursor.columns(table=table)

        col_defs = []

        for col in columns:

            name = col.column_name
            datatype = col.type_name

            sql_type = {
                "VARCHAR": "TEXT",
                "LONGCHAR": "TEXT",
                "CHAR": "TEXT",
                "INTEGER": "INT",
                "SMALLINT": "SMALLINT",
                "LONG": "BIGINT",
                "DOUBLE": "DOUBLE",
                "DATETIME": "DATETIME",
                "BIT": "BOOLEAN",
                "COUNTER": "INT AUTO_INCREMENT"
            }.get(datatype, "TEXT")

            line = f"    [{name}] {sql_type}"

            col_defs.append(line)

        create_sql = f"CREATE TABLE [{table}] (\n"
        create_sql += ",\n".join(col_defs)
        create_sql += "\n);\n\n"

        f.write(create_sql)

    # relationships
    f.write("\n-- RELATIONSHIPS\n\n")

    try:

        rels = cursor.execute("""
            SELECT
                szRelationship,
                szObject,
                szReferencedObject,
                szColumn,
                szReferencedColumn
            FROM MSysRelationships
        """).fetchall()

        for rel in rels:

            rel_name = rel.szRelationship
            child_table = rel.szObject
            parent_table = rel.szReferencedObject
            child_col = rel.szColumn
            parent_col = rel.szReferencedColumn

            fk_sql = f"""ALTER TABLE [{child_table}]
ADD CONSTRAINT [{rel_name}]
FOREIGN KEY ([{child_col}])
REFERENCES [{parent_table}]([{parent_col}]);

"""

            f.write(fk_sql)

    except Exception as e:

        print("Relationships extraction failed:")
        print(e)

print("schema.sql generated successfully")