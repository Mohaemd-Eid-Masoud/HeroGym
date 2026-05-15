-- TABLE: tblAttendance
CREATE TABLE [tblAttendance] (
    [memberID] INT,
    [CouchID] INT,
    [CourseID] INT
);

-- TABLE: tblCoach
CREATE TABLE [tblCoach] (
    [CoachID] INT AUTO_INCREMENT,
    [CoachName] TEXT,
    [Address] TEXT,
    [Gender] TEXT,
    [Mail] TEXT,
    [BirthDate] DATETIME,
    [StartDate] DATETIME,
    [EndDate] DATETIME,
    [experience] TEXT,
    [age] INT,
    [PhoneNum] TEXT,
    [CourseID] INT,
    [ShiftID] INT
);

-- TABLE: tblCourse
CREATE TABLE [tblCourse] (
    [CourseID] INT AUTO_INCREMENT,
    [CourseName] TEXT,
    [CoachID] INT,
    [Plan] TEXT,
    [CoachName] TEXT
);

-- TABLE: tblMember
CREATE TABLE [tblMember] (
    [MemberID] INT AUTO_INCREMENT,
    [MemberName] TEXT,
    [BirthDate] DATETIME,
    [Gender] TEXT,
    [Level] TEXT,
    [height] INT,
    [weight] INT,
    [Age] SMALLINT,
    [PhoneNum] TEXT,
    [CoachId] INT,
    [CoachName] TEXT,
    [CourseName] TEXT
);

-- TABLE: tblMemberShip
CREATE TABLE [tblMemberShip] (
    [MemberShipID] INT AUTO_INCREMENT,
    [MemberID] INT,
    [PAidAmount] TEXT,
    [StartDate] DATETIME,
    [EndDate] DATETIME
);

-- TABLE: tblReceptionest
CREATE TABLE [tblReceptionest] (
    [UserID] TEXT,
    [UserName] TEXT,
    [Gender] TEXT,
    [Address] TEXT,
    [Age] SMALLINT,
    [UserPassword] TEXT,
    [ShiftID] INT,
    [salary] TEXT,
    [Email] TEXT
);

-- TABLE: tblShift
CREATE TABLE [tblShift] (
    [ShiftID] INT AUTO_INCREMENT,
    [ShiftName] TEXT,
    [StartShift] DATETIME,
    [EndShift] DATETIME,
    [MemberID] INT
);


-- RELATIONSHIPS

ALTER TABLE tblMember
ADD CONSTRAINT FK_tblMember_tblCoach
FOREIGN KEY (CoachId)
REFERENCES tblCoach(CoachID);

ALTER TABLE tblCoach
ADD CONSTRAINT FK_tblCoach_tblCourse
FOREIGN KEY (CourseID)
REFERENCES tblCourse(CourseID);

ALTER TABLE tblMember
ADD CONSTRAINT FK_tblMember_tblCourse
FOREIGN KEY (CoachId)
REFERENCES tblCourse(CourseID);

ALTER TABLE tblAttendance
ADD CONSTRAINT FK_tblAttendance_tblMember
FOREIGN KEY (memberID)
REFERENCES tblMember(MemberID);

ALTER TABLE tblMemberShip
ADD CONSTRAINT FK_tblMemberShip_tblMember
FOREIGN KEY (MemberID)
REFERENCES tblMember(MemberID);

ALTER TABLE tblShift
ADD CONSTRAINT FK_tblShift_tblMember
FOREIGN KEY (MemberID)
REFERENCES tblMember(MemberID);

ALTER TABLE tblCoach
ADD CONSTRAINT FK_tblCoach_tblShift
FOREIGN KEY (ShiftID)
REFERENCES tblShift(ShiftID);

ALTER TABLE tblReceptionest
ADD CONSTRAINT FK_tblReceptionest_tblShift
FOREIGN KEY (ShiftID)
REFERENCES tblShift(ShiftID);