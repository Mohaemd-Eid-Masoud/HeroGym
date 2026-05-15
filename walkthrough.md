# Data Access Layer Refactoring Walkthrough

I have successfully reviewed and updated the DAL (Data Access Layer) and BLL (Business Logic Layer) classes to fix errors, implement missing features, and align with the database schema defined in `schema.sql`.

## Summary of Changes

### Member Data Access (`MemberDAL.java` and `MemberBLL.java`)
- **Implemented `getAllMembers()`**: Uncommented and rewrote this method to retrieve all `tblMember` records safely without complex and failing MS Access joins.
- **Fixed `createMember()`**: Updated the parameter list to match the 11 schema columns, adding `BirthDate`, `CoachName`, and `CourseName`. Used `setNull` safely to handle unprovided values.
- **Fixed `updateMember()`**: Updated the query to update all 10 editable columns instead of just 4.
- **Fixed `getMemberByName()`**: Ensured all member fields are retrieved instead of just `MemberName`, `Age`, and `Level`.

### Coach Data Access (`CoachDAL.java`)
- **Fixed `createCoach()`**: Reconciled the 11 parameter markers with the 10 data columns provided. Mapped `BirthDate`, `StartDate`, and `EndDate` correctly to `java.sql.Date`. 
- **Fixed `getAllCoach()`**: Removed the faulty `JOIN tblCourse` syntax (`CoachID = CoachName`), preventing query crashes. Now fetches natively from `tblCoach` and correctly parses `Date` fields.
- **Fixed `updateCoach()`**: Removed problematic `JOIN` syntax from the MS Access `UPDATE` query. It now reliably updates all coach details using a direct table update.

### Course Data Access (`CourseDAL.java`)
- **Schema Alignment**: Corrected the table name from `Courses` to `tblCourse` across all methods. Changed the `ID` column references to `CourseName`. 
- **Fixed `createCourse()`**: Adjusted the parameter placeholders to precisely match the inserted columns (`CourseName`, `Plan`).

### Membership Data Access (`MembershipDAL.java` and `Membership.java`)
- **Model Fix**: Added `membershipID` and `memberID` fields to `Membership.java` and fixed constructor data types to use `java.sql.Date` universally instead of conflicting with `java.util.Date`.
- **Schema Alignment**: Updated table name to `tblMemberShip` to exactly match `schema.sql`.
- **Foreign Keys**: Updated all queries to include `MemberID` to ensure memberships can actually be linked to members. Also updated `update` and `delete` methods to use `MemberShipID` instead of relying ambiguously on start and end dates.

### Receptionist Data Access (`ReceptionistDAL.java` and `ReceptionistBLL.java`)
- **Uncommented Missing Features**: Restored `getAllReceptionists()` and `updateReceptionist()` in the DAL and `getAll()`, `update()` in the BLL.
- **Schema Alignment**: Fixed table name spellings from `tblReceptionist` to `tblReceptionest`.
- **Fixed Queries**: Removed the broken `SELECT ... FROM tblShift` inside the `INSERT` query. It now inserts values directly into `tblReceptionest`.

## Verification

You can now compile the project in your IDE (like NetBeans) and use these DAL classes securely. They align strictly with the UCanAccess driver conventions and the structure of `New_Microsoft_Access_Database.accdb`.
