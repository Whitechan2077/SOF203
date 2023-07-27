Create database FLP;
USE FLP;
GO
create  table Chuyen_Nganh(
	idNganh INT IDENTITY(1,1) PRIMARY KEY,
	tenNganh nvarchar(20) NOT NULL,
	maNganh varchar(5) NOT NULL
);
GO
create table Nganh_Hep(
	idNganhHep INT IDENTITY(1,1) PRIMARY KEY,
	idNganh int CONSTRAINT FK_maNganh FOREIGN KEY (idNganh) REFERENCES Chuyen_Nganh(idNganh) NOT NULL,
	maNganhHep varchar(5) NOT NULL,
	tenNganhHep nvarchar(20) NOT NULL
);
GO
create table Mon_Hoc(
	idMonHoc INT IDENTITY(1,1) PRIMARY KEY,
	idNganh  int CONSTRAINT FK_maNganhMon FOREIGN KEY (idNganh) REFERENCES Chuyen_Nganh(idNganh) NOT NULL,
	idNganhHep int CONSTRAINT FK_maNganhHepMon FOREIGN KEY (idNganhHep) REFERENCES  Nganh_Hep(idNganhHep),
	tenMon nvarchar(20) NOT NULL,
	maMon varchar(10)
);
	GO
create table Sinh_Vien(
	idSinhVien INT IDENTITY(1,1) PRIMARY KEY,
	tenSinhVien nvarchar(25) NOT NULL,
	idNganh  int CONSTRAINT FK_maNganhSV FOREIGN KEY (idNganh) REFERENCES Chuyen_Nganh(idNganh) NOT NULL,
	idNganhHep int CONSTRAINT FK_maNganHepSV FOREIGN KEY (idNganhHep) REFERENCES  Nganh_Hep(idNganhHep),
	gioiTinh bit NOT NULL,
	sdt varchar(10) NOT NULL UNIQUE,
	diaChi nvarchar(80) NOT NULL,
	email varchar(100) NOT NULL UNIQUE,
	hinhAnh VARBINARY(MAX) NOT NULL,
);
GO
Create table Giang_Vien(
	idGiangVien INT IDENTITY(1,1) PRIMARY KEY,
	tenGiangVien nvarchar(25) NOT NULL,
	idNganh  int CONSTRAINT FK_maNganhGV FOREIGN KEY (idNganh) REFERENCES Chuyen_Nganh(idNganh) NOT NULL,
	sdt varchar(10) NOT NULL UNIQUE,
	email varchar(100) NOT NULL UNIQUE,
	gioiTinh bit NOT NULL,
	hinhAnh VARBINARY(MAX) NOT NULL,
	diaChi nvarchar(80) NOT NULL,
);
GO
Create table Can_Bo_Dao_tao(
	idCanBo INT IDENTITY(1,1) PRIMARY KEY,
	tenCanBo nvarchar(25) NOT NULL,
	sdt varchar(10) NOT NULL UNIQUE,
	email varchar(100) NOT NULL UNIQUE,
	hinhAnh VARBINARY(MAX) NOT NULL,
	diaChi nvarchar(80) NOT NULL,
	gioiTinh bit NOT NULL,
);
Go
Create table toaNha(
	idToa INT IDENTITY(1,1) PRIMARY KEY,
	maToa varchar(1) NOT NULL,
);
Go
Create table phongHoc(
	idPhong INT IDENTITY(1,1) PRIMARY KEY,
	idToa INT CONSTRAINT FK_idToa FOREIGN KEY(idToa)REFERENCES toaNha(idToa) NOT  NULL,
	soPhong int NOT NULL
);
Go
Create table Users(
	userId  INT IDENTITY(1,1) PRIMARY KEY,
	username varchar(90) NOT NULL,
	password varchar(20) NOT NULL,
	idSinhVien int CONSTRAINT FK_idUserSinhVien FOREIGN KEY(idSinhVien) REFERENCES Sinh_Vien(idSinhVien),
	idGiangVien int CONSTRAINT FK_idUserGiangVien FOREIGN KEY(idGiangVien) REFERENCES  Giang_Vien(idGiangVien),
	idCanBo int CONSTRAINT FK_idUserCanBo FOREIGN KEY(idCanBo) REFERENCES  Can_Bo_Dao_tao(idCanBo)
);
Go
Create table lopHoc(
	idLop INT IDENTITY(1,1) PRIMARY KEY,
	maLop varchar(15),
	idNganh  int CONSTRAINT FK_maNganhChoLop FOREIGN KEY (idNganh) REFERENCES Chuyen_Nganh(idNganh) NOT NULL,
	idNganhHep int CONSTRAINT FK_IDNganhHepChoLop FOREIGN KEY(idNganhHep)REFERENCES Nganh_Hep(idNganhHep),
	idPhong int constraint fk_idPhongHoc FOREIGN KEY (idPhong) REFERENCES phongHoc(idPhong),
);
GO

GO
SELECT * FROM lopHoc
SELECT * FROM Phan_Cong
SELECT * FROM ThamGiaHoc
SELECT * FROM phongHoc
create table Ky_hoc(
	idKy INT IDENTITY(1,1) PRIMARY KEY,
	maKy varchar(5) NOT NULL,
	tenKy varchar(20) NOT NULL,
);
GO
create table Phan_Cong(
	idPhanCong INT IDENTITY(1,1) PRIMARY KEY,
	idLop INT CONSTRAINT FK_IDLopPhanCong FOREIGN KEY(idLop) REFERENCES lopHoc(idLop), 
	idMonHoc INT CONSTRAINT FK_IDMonChoLop FOREIGN KEY(idMonHoc) REFERENCES Mon_Hoc(idMonHoc), 
	idGiangVien INT CONSTRAINT FK_IDGiangVienPhanCong FOREIGN KEY(idGiangVien) REFERENCES Giang_Vien(idGiangVien)
	);
create table ThamGiaHoc(
	idThamGia INT IDENTITY(1,1) PRIMARY KEY,
	idLop INT CONSTRAINT FK_IDSinhVienTrongLop  FOREIGN KEY(idLop) REFERENCES lopHoc(idLop),
	idSinhVien INT CONSTRAINT FK_IDSinhVienPhanCong FOREIGN KEY(idSinhVien) REFERENCES  Sinh_Vien(idSinhVien)
);
GO
create table Diem(
	maDiem INT IDENTITY(1,1) PRIMARY KEY,
	idSinhVien int CONSTRAINT FK_idMarkSinhVien FOREIGN KEY(idSinhVien) REFERENCES Sinh_Vien(idSinhVien) NOT NULL,
	idMonHoc INT  CONSTRAINT FK_SubjectId FOREIGN KEY(idMonHoc)REFERENCES Mon_Hoc(idMonHoc)NOT NULL,
	lab1 float,
	lab2 float,
	lab3 float,
	lab4 float,
	lab5 float,
	lab6 float,
	lab7 float,
	lab8 float,
	asm1 float,
	asm2 float,
	asmBaoVe float,
	tbm float,
);
GO
create or alter procedure p_insertMark
	@idSinhVien int,@idMonHoc INT,	
	@lab1 float,
	@lab2 float,
	@lab3 float,
	@lab4 float,
	@lab5 float,
	@lab6 float,
	@lab7 float,
	@lab8 float,
	@asm1 float,
	@asm2 float,
	@asmBaoVe float
AS
	BEGIN
	INSERT INTO Diem(idSinhVien,idMonHoc,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe)
		VALUES(@idSinhVien,@idMonHoc,	
	@lab1 ,
	@lab2 ,
	@lab3 ,
	@lab4,
	@lab5,
	@lab6,
	@lab7,
	@lab8,
	@asm1,
	@asm2,
	@asmBaoVe
	)
	END
GO
Create trigger tg_insertMark On Diem
FOR insert
AS
BEGIN
	DECLARE @mark float
	SELECT @mark = (lab1+lab2+lab3+lab4+lab5+lab6+lab7+lab8+asm1+asm2+asmBaoVe)/11 FROM  inserted
	INSERT INTO Diem(tbm)
		VALUES(@mark)
END
GO
Create OR ALTER trigger  tg_updateMark On Diem
FOR update
AS
BEGIN
	DECLARE @mark float
	DECLARE @idSinhVien int
	DECLARE @subjectID int
	SELECT @subjectID=idMonHoc FROM inserted
	SELECT @idSinhVien = idSinhVien FROM inserted
	SELECT @mark = (lab1+lab2+lab3+lab4+lab5+lab6+lab7+lab8+asm1+asm2+asmBaoVe)/11 FROM  inserted
	WHERE idSinhVien =@idSinhVien AND idMonHoc = @subjectID
	UPdate Diem SET tbm = @mark WHERE idSinhVien =@idSinhVien AND idMonHoc = @subjectID
END
SELECT * FROM Diem
	UPdate Diem SET lab1 = 10 WHERE idSinhVien =1 AND idMonHoc = 56
GO
create or alter PROCEDURE p_insertNganh
	@maNganh varchar(5),@tenNganh nvarchar(20)
AS
BEGIN
	INSERT INTO Chuyen_Nganh(maNganh,tenNganh)
	VALUES(@maNganh,@tenNganh);
END
GO
create or alter procedure p_insertClass
	@idNganh int,@idNganhHep int,@idPhong int
AS
BEGIN
	INSERT INTO lopHoc(idNganh,idNganhHep,idPhong)
	VALUES(@idNganh,@idNganhHep,@idPhong);
END
SELECT * FROM lopHoc
SELECT * FROM Chuyen_Nganh
SELECT * FROM Nganh_Hep
EXEC p_insertClass 1,1,1 
GO
EXEC p_insertClass 
SELECT *  FROM lopHoc
SELECT * FROM Mon_Hoc
EXEC p_insertClass 51,3
GO
CREATE OR ALTER trigger tg_genClassCode ON lopHoc
for insert
AS
BEGIN
	DECLARE @majorId int,@MajorDetailsId int,@MajorDetailsCode varchar(5),@idClass int
	SELECT @idClass=idLop FROM inserted
	SELECT @majorId =idNganh FROM inserted
	SELECT @MajorDetailsId =  idNganhHep FROM  inserted
	SELECT @MajorDetailsCode = maNganhHep FROM Nganh_Hep WHERE idNganhHep = @MajorDetailsId
	UPDATE lopHoc set maLop = @MajorDetailsCode + CONVERT(varchar,@majorId)+CONVERT(varchar,@MajorDetailsId)+CONVERT(varchar,@idClass)
	WHERE idLop = @idClass
END
GO

EXEC p_insertClass 51,1
EXEC p_insertClass 33,1
EXEC p_insertClass 38,2

DELETE FROM lopHoc
SELECT * FROM lopHoc
SELECT * FROM Mon_Hoc
SELECT * FROM Nganh_Hep
EXEC p_insertClass 55,4
GO
SELECT  * FROM Mon_Hoc
SELECT * FROM lopHoc
ALTER TABLE lopHoc
	ADD maLop varchar(10)
GO
create or alter procedure p_insertPhanCong
 @idLop INT,@idMon int
 AS
 BEGIN
	insert into Phan_Cong(idLop,idMonHoc)
		values(@idLop,@idMon)
 END
GO
SELECT * FROM Phan_Cong
create or alter procedure p_insertClassJoining
	@idPhanCong INT,@idSinhVien INT
AS
BEGIN
	INSERT INTO ThamGiaHoc(idPhanCong,idSinhVien)
		VALUES(@idPhanCong,@idSinhVien)
END
GO
create or alter PROCEDURE p_insertNganhHep
	@idNganh int,@maNganhHep varchar(5),@tenNganhHep nvarchar(20)
AS
BEGIN
	INSERT INTO Nganh_Hep(idNganh,maNganhHep,tenNganhHep)
	VALUES(@idNganh,@maNganhHep,@tenNganhHep);
END
GO
create or alter PROCEDURE p_insertMonHoc
	@idNganh  int,@idNganhHep int,@tenMon nvarchar(20)
AS
BEGIN
	INSERT INTO  Mon_Hoc(idNganh,idNganhHep,tenMon)
	VALUES(@idNganh,@idNganhHep,@tenMon);
END
SELECT * FROM Mon_Hoc
GO
create or alter PROCEDURE p_insertSinhVien
	@tenSinhVien nvarchar(25),@idNganh  int,@idNganhHep int,@sdt varchar(10),@diaChi nvarchar(80),@email varchar(100),@hinhAnh VARBINARY(MAX),@gioiTinh bit
AS
BEGIN
	INSERT INTO Sinh_Vien(tenSinhVien,idNganh,idNganhHep,sdt,diaChi,email,hinhAnh,gioiTinh)
	VALUES(@tenSinhVien,@idNganh,@idNganhHep,@sdt,@diaChi,@email,@hinhAnh,@gioiTinh);
END
GO
CREATE or alter PROCEDURE p_insertLecture
	@tenGiangVien nvarchar(25),@idNganh  int,@sdt varchar(10),@email varchar(100),@gioiTinh bit,@hinhAnh VARBINARY(MAX),@diaChi nvarchar(80)
AS 
	BEGIN 
		INSERT into Giang_Vien(tenGiangVien,idNganh,sdt,email,gioiTinh,hinhAnh,diaChi)
			VALUES(	@tenGiangVien,@idNganh,@sdt,@email,@gioiTinh,@hinhAnh,@diaChi);
	END
GO
create or alter PROCEDURE p_insertUsers
	@username varchar(90),@password varchar(20),@idSinhVien int,@idGiangVien int,@idCanBo int
AS
	BEGIN 
	INSERT INTO Users(username,password ,idSinhVien,idGiangVien,idCanBo)
		VALUES(@username,@password,@idSinhVien,@idGiangVien,@idCanBo)
	END
GO
insert into Ky_hoc(maKy,tenKy)
	VALUES('SP','Spring'),
		  ('SU','Summer'),
		  ('FA','Fall');
	GO
SELECT * FROM Ky_hoc
SELECT * FROM Mon_Hoc
INSERT INTO Users(username,password ,idSinhVien,idGiangVien,idCanBo)
	VALUES('dungbhph35753@fpt.edu.vn','123',1,null,null),
		('khuongtm@fpt.edu.vn','123',2,null,null),
		('minhvl@fpt.edu.vn','123',3,null,null),
		('hieupt35753@fpt.edu.vn','123',4,null,null),
		('datnt@fpt.edu.vn','123',5,null,null),
		('luannh@fpt.edu.vn','123',6,null,null),
		('namdt@fpt.edu.vn','123',7,null,null),
		('linhhq@fpt.edu.vn','123',8,null,null),
		('thaontt@fpt.edu.vn','123',9,null,null),
		('thaontt@fpt.edu.vn','123',10,null,null),
		('nguyennt@fpt.edu.vn','123',11,null,null),
		('thunk@fpt.edu.vn','123',12,null,null),
		('thuvk@fpt.edu.vn','123',13,null,null);
GO  
GO
insert into Ky_hoc()
	VALUES();
GO
create  or alter PROCEDURE p_insertBuilding
	@maToa varchar(1)
AS
BEGIN
	INSERT INTO toaNha(maToa)
	VALUES(@maToa)
END
GO
create or alter procedure p_insertRoom
	@idToa INT,@soPhong int
AS
BEGIN
	insert into phongHoc(idToa,soPhong)
		VALUES(@idToa,@soPhong)
END
GO
Create or alter procedure p_insertCanBo
 @tenCanBo nvarchar(25),@sdt varchar(10),@email varchar(100),@hinhAnh VARBINARY(MAX),@diaChi nvarchar(80),@gioiTinh bit
AS
	BEGIN
		Insert into Can_Bo_Dao_tao(tenCanBo,sdt,email,hinhAnh,diaChi,gioiTinh)
			Values(@tenCanBo,@sdt,@email,@hinhAnh,@diaChi,@gioiTinh)
	END
GO
CREATE or alter Trigger tg_InsertUserSinhVien on Sinh_Vien 
FOR insert
	AS
	BEGIN
	DECLARE @idSinhVien int,@username varchar(90)
		SELECT @idSinhVien=idSinhVien FROM inserted
		SELECT @username = email FROM inserted
		INSERT INTO Users(username,password ,idSinhVien,idGiangVien,idCanBo)
			VALUES(@username,'123',@idSinhVien,null,null);
	END
GO
CREATE or alter Trigger tg_InsertUserGiangVien on Giang_Vien
FOR insert
	AS
	BEGIN
	DECLARE @idGiangVien int,@username varchar(90)
		SELECT @idGiangVien = idGiangVien FROM inserted
		SELECT @username = email FROM inserted
		INSERT INTO Users(username,password ,idSinhVien,idGiangVien,idCanBo)
			VALUES(@username,'123',null,@idGiangVien,null);
	END
GO
CREATE or alter Trigger tg_InsertUserCanBoDaoTao on Can_Bo_Dao_tao
FOR insert
	AS
	BEGIN
	DECLARE @idCanBo int,@username varchar(90)
		SELECT @idCanBo = idCanBo FROM inserted
		SELECT @username = email FROM inserted
		INSERT INTO Users(username,password ,idSinhVien,idGiangVien,idCanBo)
			VALUES(@username,'123',null,null,@idCanBo);
	END
GO

GO
Create or alter PROCEDURE p_updateStudent
		@tenSinhVien nvarchar(25),@idNganh  int,@idNganhHep int,@sdt varchar(10),@diaChi nvarchar(80),@email varchar(100),@hinhAnh VARBINARY(MAX),@gioiTinh bit,@idSinhVien int
AS
BEGIN
	UPDATE Sinh_Vien 
		SET tenSinhVien =@tenSinhVien ,idNganh= @idNganh,idNganhHep=@idNganhHep,sdt=@sdt,diaChi=@diaChi,email=@email,hinhAnh=@hinhAnh,gioiTinh=@gioiTinh
		WHERE idSinhVien =@idSinhVien
END
GO
Create or alter procedure p_updateLecture
	@tenGiangVien nvarchar(25),@idNganh  int,@sdt varchar(10),@email varchar(100),@gioiTinh bit,@hinhAnh VARBINARY(MAX),@diaChi nvarchar(80),@idGiangVien int
AS
	BEGIN
		UPDATE Giang_Vien SET tenGiangVien=@tenGiangVien,idNganh=@idNganh,sdt=@sdt,email=@email,gioiTinh=@gioiTinh,hinhAnh=@hinhAnh,diaChi=@diaChi
			WHERE idGiangVien =@idGiangVien 
	END	
GO
Create or alter trigger tg_updateLectureUser ON Giang_Vien
	for update 
		AS
	BEGIN
		DECLARE @id int,@username varchar(100)
		SELECT @id=idGiangVien,@username=email FROM inserted
		UPDATE Users SET username = @username
		WHERE idGiangVien = @id
	END
Go
CREATE or alter trigger tg_updateStudentUser on Sinh_Vien 
for update
	AS
	BEGIN
		DECLARE @id int,@username varchar(100)
		SELECT @id=idSinhVien,@username=email FROM inserted
		UPDATE Users SET username = @username
		WHERE idSinhVien = @id
	END
Select * from users
GO
GO
	SELECT * FROM Mon_Hoc
	Select * from Phan_Cong
GO
create or alter procedure p_insertPhanCong
@idLop INT, @idGiangVien INT,@idPhong INT ,@idKy INT 
AS
BEGIN
	Insert into Phan_Cong(idLop,idGiangVien,idPhong,idKy)
	Values(@idLop,@idGiangVien,@idPhong,@idKy);
END
GO
SElect * from Phan_Cong
SELECT * FROm lopHoc
SELECT * FROM phongHoc
SELECT * FROM Ky_hoc

SELECT * FROM Phan_Cong
GO

CREATE OR ALTER FUNCTION dbo.LocDanhSachLopDaTonTai()
RETURNS TABLE
AS
RETURN
(
	SELECT lopHoc.*
FROM lopHoc
LEFT JOIN Phan_Cong ON lopHoc.idLop = Phan_Cong.idLop
WHERE Phan_Cong.idLop IS NULL
);
GO
CREATE OR ALTER FUNCTION dbo.GetClassData()
RETURNS TABLE
AS
RETURN
(
	SELECT lopHoc.idLop,lopHoc.maLop,lopHoc.idNganh,lopHoc.idNganhHep,lopHoc.idPhong,CONCAT(toaNha.maToa,phongHoc.soPhong)AS 'tenPhong',
			Nganh_Hep.tenNganhHep,Chuyen_Nganh.tenNganh
		FROM lopHoc JOIN Nganh_Hep ON lopHoc.idNganhHep = Nganh_Hep.idNganhHep 
					JOIN Chuyen_Nganh ON Nganh_Hep.idNganh = Chuyen_Nganh.idNganh 
					JOIN phongHoc ON lopHoc.idPhong = phongHoc.idPhong JOIn toaNha ON  phongHoc.idToa = toaNha.idToa
);
SELECT * FROM toaNha
SELECT * FROM lopHoc
GO
create or alter trigger tg_autoInsertSubjectCode ON  Mon_Hoc
for insert
AS
BEGIN
	DECLARE @subJectId int,@maJorId int,@majorDetailsId int,@MajorDetailsCode varchar(5),@maMon nvarchar(20),
	@idMajorDtails int
	SELECT @subJectId = idMonHoc,@maJorId=idNganh,@majorDetailsId=idNganhHep FROM inserted
	SELECT @idMajorDtails = idNganhHep FROM Mon_Hoc WHERE idMonHoc = @subJectId
	SELECT @MajorDetailsCode=maNganhHep FROM Nganh_Hep WHERE idNganhHep = @majorDetailsId
	print 'alo '+Cast(@majorDetailsId AS varchar);
	IF(@majorDetailsId is not null)
	BEGIN
		SET @maMon =@MajorDetailsCode+CAST(@maJorId AS varchar(5))+CAST(@majorDetailsId -AS varchar(5))+CAST(@subJectId AS varchar(5))
				UPDATE Mon_Hoc SET maMon = @maMon
			WHERE idMonHoc = @subJectId
		
	END
	ELSE
	BEGIN
			SET @maMon ='COM'+CAST(@maJorId AS varchar(5))+CAST(0 as varchar(5))+CAST(@subJectId AS varchar(5))
		UPDATE Mon_Hoc SET maMon = @maMon
			WHERE idMonHoc = @subJectId
	END
END
Go
EXEC p_insertMonHoc  1,NULL,'Font-End';

DELETE FROM Mon_Hoc WHERE idNganhHep is null
SELECT * FROM Mon_Hoc 
SELECT * FROM Chuyen_Nganh
SELECT * FROM Nganh_Hep
EXEC p_updateStudent 'Bui Dung',1,2,'0397767819','Phú Thọ','dungbhphC@fpt.edu.vn',0011,1,1;
GO
  CREATE OR Alter procedure p_UpdateSubject
  AS
GO
EXEC p_insertNganh 'IT',N'Công Nghệ Thông Tin';
EXEC p_insertNganhHep 1,'SD',N'Phát triển phần mềm';
EXEC p_insertNganhHep 1,'WEB',N'Lập trình web';
EXEC p_insertNganhHep 1,'MOB',N'Lập trình Mobile';
EXEC p_insertNganhHep 1,'DAT',N'Xử lý dữ liệu';
EXEC p_insertNganhHep 1,'GAM',N'Lập trình Game';
GO
EXEC p_insertMonHoc  1,1,N'Lập trình Java 1','MOB1024'
EXEC p_insertMonHoc  1,1,N'Lập trình Java 2','MOB1023'
EXEC p_insertMonHoc 1,2,N'Thiết kế trang web','WEB1013'
EXEC p_insertMonHoc 1,2,N'Lập trình cơ sở với JavaScript','WEB1043'
EXEC p_insertMonHoc 1,NULL,N'Cơ sở dữ liệu','COM2012'
EXEC p_insertMonHoc 1,NULL,N'Hệ quản trị dữ liệu','COM2043'
EXEC p_insertMonHoc 1,NULL,N'Tin học','COM1014'
GO
EXEC p_insertSinhVien N'Bùi Hoàng Dũng',1,1,'0397767819',N'Khu 10 Vĩnh Chân','dungbhph35753@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Trần Mạnh Khương',1,1,'0397767813',N'Nam Định','khuongtm@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Lâm Văn Minh',1,1,'0397767823',N'Hà Nội','minhvl@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Phùng Trọng hiếu',1,2,'0397767814',N'Khu 7 Vĩnh Chân','hieupt35753@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Nguyễn Tiến Đạt',1,3,'0357767814',N'Hương Xạ','datnt@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Nguyễn Hoàng Luân',1,1,'0357767812',N'Ba Vì','luannh@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Đỗ Trọng Nam',1,2,'0397767824',N'Vĩnh Chân','namdt@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Hoàng Quang Linh',1,1,'0397762824',N'Hà Nội','linhhq@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Nguyễn Thị Thanh Thảo',1,3,'0394222824',N'Hà Nội','thaontt@fpt.edu.vn',10101010,False;
EXEC p_insertSinhVien N'Nông Tiến Sơn',1,1,'0337762824',N'Cao Bằng','sonnt@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Nguyễn Thái Nguyên',1,1,'0333762524',N'Cáo Điền','nguyennt@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Vũ Kim Thư',1,1,'0394222224',N'Hà Nội','thunk@fpt.edu.vn',10101010,False;
EXEC p_insertSinhVien N'Vu Kim Thư',1,4,'0394222624',N'Hà Nội','thuvk@fpt.edu.vn',10101010,False;
EXEC p_insertSinhVien N'Vũ Tiến Vinh',1,2,'0397367814',N'Yên Luật','vinhvt@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Nguyễn Quang Huy',1,2,'0392367814',N'Hà Nội','huynq@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Trần Quang Khải',1,1,'0391367814',N'Hà Nội','khaitq@fpt.edu.vn',10101010,true;
EXEC p_insertSinhVien N'Phạm Hương',1,1,'0391367214',N'Hà Nội','huongp@fpt.edu.vn',10101010,false;
GO
EXEC p_insertLecture N'Phạm Hà An',1,'0345545879','anph@fpt.edu.vn',true,0111001111111110,N'Hà Nội';
EXEC p_insertLecture N'Phan Gia Khánh',1,'0345525879','khanhph@fpt.edu.vn',true,0111001111111110,N'Hà Nội';
EXEC p_insertLecture N'Nguyễn Anh Dũng',1,'0545543879','dungna@fpt.edu.vn',true,0111001111111110,N'Hà Nội';
EXEC p_insertLecture N'Vũ Văn Nguyên',1,'0555543879','nguyenvv@fpt.edu.vn',true,0111001111111110,N'Hà Nội';
EXEC p_insertLecture N'Nguyễn Khánh Huyền',1,'0455543879','huyennk@fpt.edu.vn',false,0111001111111110,N'Hà Nội';
EXEC p_insertLecture N'Trần Tuấn Phong',1,'0555343379','phongtt@fpt.edu.vn',true,0111001111111110,N'Hà Nội';
EXEC p_insertLecture N'Nguyễn Thúy Hằng',1,'0455513879','hangnt@fpt.edu.vn',false,0111001111111110,N'Hà Nội';
EXEC p_insertLecture N'Trần Thị Loan',1,'0453513879','loantt@fpt.edu.vn',false,0111001111111110,N'Hà Nội';

GO
EXEC p_insertUsers 'anph@fpt.edu.vn','123',NULL,1,NULL;
EXEC p_insertUsers 'dungna@fpt.edu.vn','123',NULL,3,NULL;
EXEC p_insertUsers 'nguyenvv@fpt.edu.vn','123',NULL,4,NULL;
EXEC p_insertUsers 'huyennk@fpt.edu.vn','123',NULL,5,NULL;
EXEC p_insertUsers 'phongtt@fpt.edu.vn','123',NULL,6,NULL;
EXEC p_insertUsers 'khanhph@fpt.edu.vn','123',NULL,8,NULL;
EXEC p_insertUsers 'hangnt@fpt.edu.vn','123',NULL,9,NULL;
SELECT * FROM Can_Bo_Dao_tao
GO
EXEC p_insertMonHoc  
GO
EXEC p_insertNganhHep 
EXEC p_insertBuilding 
selecT * FROM toaNha
select * from Nganh_Hep
GO
EXEC p_insertCanBo 'Bùi Hoàng Dũng','039487848','dungbh@gmail.com',0011000111,N''
EXEC p_updateLecture 'Linh Remind',7,'0354451759','linhRemind@gmail.com',false,0011111011,'HCM',21
GO
EXEC p_insertBuilding 'P';
EXEC  p_insertRoom 1,101;
EXEC  p_insertRoom 1,102;
EXEC  p_insertRoom 1,103;
EXEC  p_insertRoom 1,104;
EXEC  p_insertRoom 1,105;
EXEC  p_insertRoom 1,107;
EXEC  p_insertRoom 1,108;
EXEC  p_insertRoom 1,109;
EXEC  p_insertRoom 1,110;
GO
SELECT  toaNha.idToa,maToa,CONCAT(maToa,soPhong) AS tenPhong,phongHoc.idPhong FROM toaNha JOIN phongHoc ON toaNha.idToa = phongHoc.idToa
SELECT * FROM Giang_Vien
SELECT * FROM Mon_Hoc
SELECT * FROM Nganh_Hep
DELETE FROM Nganh_Hep WHERE maNganhHep like 'BL'
SELECT * FROM Chuyen_Nganh
SELECT * FROM Nganh_Hep JOIN Chuyen_Nganh ON Nganh_Hep.idNganh = Chuyen_Nganh.idNganh
SELECT * FROM Sinh_Vien
SELECT * FROM Users;
SELECT Sinh_Vien.idSinhVien,Nganh_Hep.tenNganhHep,Sinh_Vien.tenSinhVien,Sinh_Vien.gioiTinh,tenNganh,Sinh_Vien.email,Sinh_Vien.diaChi
FROM Sinh_Vien JOIN Nganh_Hep ON Sinh_Vien.idNganhHep = Nganh_Hep.idNganhHep JOIN Chuyen_Nganh on Nganh_Hep.idNganh = Chuyen_Nganh.idNganh
GO
UPDATE Chuyen_Nganh SET maNganh = 'MKSP' WHERE maNganh = N'Làm Ð'
CREATE OR ALTER FUNCTION dbo.GetStudentData()
RETURNS TABLE
AS
RETURN
(
    SELECT Sinh_Vien.idSinhVien, Nganh_Hep.tenNganhHep, Sinh_Vien.tenSinhVien,
           Sinh_Vien.gioiTinh, tenNganh, Sinh_Vien.email, Sinh_Vien.diaChi,Sinh_Vien.sdt,Sinh_Vien.hinhAnh,Nganh_Hep.idNganhHep,Chuyen_Nganh.idNganh
    FROM Sinh_Vien
    JOIN Nganh_Hep ON Sinh_Vien.idNganhHep = Nganh_Hep.idNganhHep
    JOIN Chuyen_Nganh ON Nganh_Hep.idNganh = Chuyen_Nganh.idNganh
);
	SELECT * FROm dbo.GetStudentData()
	select * from dbo.LectureData();
GO
CREATE OR ALTER FUNCTION dbo.LectureData()
RETURNS TABLE
AS
RETURN
(
SELECT Giang_Vien.idGiangVien,Giang_Vien.tenGiangVien,Giang_Vien.gioiTinh,Giang_Vien.email,Giang_Vien.diaChi,Chuyen_Nganh.tenNganh,Giang_Vien.hinhAnh,Giang_Vien.sdt,Giang_Vien.idNganh 
	FROM Giang_Vien JOIN Chuyen_Nganh ON Giang_Vien.idNganh = Chuyen_Nganh.idNganh
);
GO
 CREATE OR ALTER FUNCTION dbo.RomDetails()
RETURNS TABLE
AS
RETURN
(
SELECT  toaNha.idToa,maToa,CONCAT(maToa,soPhong) AS tenPhong,phongHoc.idPhong,soPhong FROM toaNha FULL JOIN phongHoc ON toaNha.idToa = phongHoc.idToa

);
SELECT * FROM  dbo.RomDetails()
SELECT * FROM toaNha;
select * from phongHoc
DELETE FROM phongHoc where soPhong = 0
EXEC p_insertMonHoc 

EXEC p_insertMonHoc
GO
CREATE OR ALTER FUNCTION dbo.SubjectData()
RETURNS TABLE
AS
RETURN
(
Select Mon_Hoc.idMonHoc,Mon_Hoc.maMon,Mon_Hoc.tenMon,Nganh_Hep.idNganhHep,Nganh_Hep.tenNganhHep,Chuyen_Nganh.idNganh,Chuyen_Nganh.tenNganh
	from Mon_Hoc LEFT JOIN  Nganh_Hep ON Mon_Hoc.idNganhHep = Nganh_Hep.idNganhHep LEFT JOIN Chuyen_Nganh
	ON Mon_Hoc.idNganh= Chuyen_Nganh.idNganh
);
SELECT * from   dbo.SubjectData();
	
	SELECT * FROM lopHoc
	SELECT * FROM Phan_Cong

select * from Chuyen_Nganh JOIN Nganh_Hep ON Chuyen_Nganh.idNganh = Nganh_Hep.idNganh where idNganh = @id
GO
CREATE FUNCTION GetChuyenNganhById
(
    @id INT
)
RETURNS TABLE
AS
RETURN
(
    SELECT Chuyen_Nganh.idNganh,Chuyen_Nganh.maNganh,Chuyen_Nganh.tenNganh,Nganh_Hep.idNganhHep,Nganh_Hep.maNganhHep,Nganh_Hep.tenNganhHep
    FROM Chuyen_Nganh
    JOIN Nganh_Hep ON Chuyen_Nganh.idNganh = Nganh_Hep.idNganh
    WHERE Nganh_Hep.idNganh = @id
);select * from dbo.LectureData();
EXEC p_insertMonHoc 
GO
CREATE OR ALTER FUNCTION dbo.GetClassData()
RETURNS TABLE
AS
RETURN
(
	SELECT maLop,Mon_Hoc.tenMon FROM lopHoc JOIN Mon_Hoc ON lopHoc.idMonHoc = Mon_Hoc.idMonHoc
);
SELECT RomDetails.idPhong,RomDetails.tenPhong,RomDetails.idToa,RomDetails.maToa,RomDetails.soPhong,RomDetails.maToa
		FROM  dbo.RomDetails() LEFT JOIN lopHoc ON lopHoc.idPhong = RomDetails.idPhong 
		where lopHoc.idLop is null ANd RomDetails.idToa = 1
	WHERE idToa = 1
SELECT  * FROM dbo.GetClassData()	
SELECT * FROM lopHoc
SELECT * FROM Mon_Hoc

DELETE FROM Phan_Cong
EXEC p_insertPhanCong 3,56	
GO
SELECT mh.idMonHoc,mh.maMon,mh.tenMon
FROM lopHoc lh
CROSS JOIN Mon_Hoc mh 
LEFT JOIN Phan_Cong pc ON pc.idLop = lh.idLop AND pc.idMonHoc = mh.idMonHoc
WHERE lh.idLop = 3 AND mh.idNganh = 1
AND pc.idPhanCong IS NULL;
SELECT * FROM Phan_Cong
EXEC p_insertPhanCong 
GO
SELECT Phan_Cong.idPhanCong,Phan_Cong.idLop,lopHoc.maLop,Phan_Cong.idMonHoc,Mon_Hoc.maMon,Mon_Hoc.tenMon,Phan_Cong.idMonHoc 
	  FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop 
			JOIN Mon_Hoc ON Mon_Hoc.idMonHoc = Phan_Cong.idMonHoc
		WHERE lopHoc.idLop = 1
SELECT Phan_Cong.idLop,Giang_Vien.idGiangVien,Giang_Vien.tenGiangVien  FROM Phan_Cong LEFT JOIN Giang_Vien ON Phan_Cong.idGiangVien = Giang_Vien.idGiangVien
	WHERE Phan_Cong.idGiangVien is null AND Phan_Cong.idLop = 3
SELECT* FROM Giang_Vien
SELECT * FROM Phan_Cong WHERE Phan_Cong.idLop = 3

SELECT gv.idGiangVien, gv.tenGiangVien
FROM Giang_Vien gv
LEFT JOIN Phan_Cong pc ON gv.idGiangVien = pc.idGiangVien AND pc.idLop = 3 AND gv.idNganh =1
WHERE pc.idPhanCong IS NULL;

SELECT Phan_Cong.idMonHoc,Mon_Hoc.maMon,Mon_Hoc.tenMon 
	FROm Phan_Cong JOIN Mon_Hoc ON Phan_Cong.idMonHoc = Mon_Hoc.idMonHoc
	WHERE Phan_Cong.idLop = 3
SELECT * FRom Phan_Cong WHERE idGiangVien is NULL
SELECT * FROM Phan_Cong WHERE Phan_Cong.idLop = 14
UPDATE Phan_Cong SET idGiangVien = ? WHERE idLop = ? AND idMonHoc = ?
GO
SELECT lopHoc.idLop,lopHoc.maLop,Mon_Hoc.idMonHoc,Mon_Hoc.maMon,Mon_Hoc.tenMon,Phan_Cong.idGiangVien,Giang_Vien.tenGiangVien,Mon_Hoc.idMonHoc
		FROM Phan_Cong LEFT JOIN Giang_Vien ON Phan_Cong.idGiangVien = Giang_Vien.idGiangVien
		FULL JOIN lopHoc ON Phan_Cong.idLop =  lopHoc.idLop FULL JOIN Mon_Hoc ON Mon_Hoc.idMonHoc= Phan_Cong.idMonHoc
WHERE Phan_Cong.idLop = 14
DELETE  FROM Phan_Cong
DELETE FROM lopHoc
SELECT * FROM lopHoc
SELECT Sinh_Vien.idSinhVien,Sinh_Vien.tenSinhVien 
     FROM Sinh_Vien left JOIN ThamGiaHoc ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien
	 WHERE Sinh_Vien.idNganhHep = 1  AND ThamGiaHoc.idSinhVien is null 
GO
SELECT * FROM ThamGiaHoc
DELETE FROM ThamGiaHoc
SELECT * FROM Sinh_Vien

GO
CREATE OR ALTER Trigger tg_insertClassJoining ON LopHoc 
for insert 
	AS
	BEGIN
	DECLARE @classID int
	SELECT @classID = idLop FROM inserted
	INSERT INTO ThamGiaHoc(idLop)
		VALUES(@classID)
	END
GO
CREATE or ALTER Trigger tg_AutoInsertSubject on ThamGiaHoc
for insert
AS
	BEGIN
	DECLARE @ClassID int
	SELECT @ClassID = idLop FROM inserted
	DECLARE @tableSubject table(studentId int,subjectId int)
	DECLARE @studentID int
	SELECT @studentID = idSinhVien FROM inserted
	INSERT into @tableSubject
	SELECT idSinhVien,idMonHoc
	FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop JOIN ThamGiaHoc ON ThamGiaHoc.idLop = lopHoc.idLop
	WHERE lopHoc.idLop = @ClassID AND ThamGiaHoc.idSinhVien = @studentID
	INSERT INTO Diem(idSinhVien,idMonHoc,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm)
		SELECT studentId,subjectId,0,0,0,0,0,0,0,0,0,0,0,0 FROM @tableSubject
	END
GO
SELECT * FROM Diem
SELECT * FROM lopHoc 
SELECT * FROM Sinh_Vien
SELECT * FROM Phan_Cong
SELECT * FROM Giang_Vien
SELECT * FROM  Diem
SELECT * FROM ThamGiaHoc
DELETE FROM ThamGiaHoc
DELETE FROM Diem
INSERT INTO ThamGiaHoc(idLop,idSinhVien)
	VALUES(16,1)
SELECT idSinhVien,idMonHoc
	FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop JOIN ThamGiaHoc ON ThamGiaHoc.idLop = lopHoc.idLop
	WHERE lopHoc.idLop = 16
	--Diem sinh vien
	SELECT Phan_Cong.idLop,Diem.idSinhVien,Sinh_Vien.tenSinhVien,Diem.idMonHoc,tenSinhVien,Mon_Hoc.tenMon,Mon_Hoc.maMon,
		lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm
		FROM Giang_Vien JOIN
	     Phan_Cong on Giang_Vien.idGiangVien = Phan_Cong.idGiangVien 
		 JOIN Diem ON Phan_Cong.idMonHoc = Diem.idMonHoc
		 JOIN Sinh_Vien on Diem.idSinhVien = Sinh_Vien.idSinhVien JOIN Mon_Hoc on Diem.idMonHoc = Mon_Hoc.idMonHoc
		 Group by Phan_Cong.idLop,Diem.idSinhVien,Sinh_Vien.tenSinhVien,Diem.idMonHoc,tenSinhVien,Mon_Hoc.tenMon,Mon_Hoc.maMon,
		lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm
		HAVING Diem.idMonHoc = 56 ANd Phan_Cong.idLop =22
		SELECT * FROM Phan_Cong
		SELECT * FROm ThamGiaHoc WHERE idLop=20 
		SELECT * FROm Diem
		SELECT * FROM Giang_Vien
		SELECT * FROM lopHoc
		SELECT * FROM Mon_Hoc
SELECT lopHoc.maLop,Sinh_Vien.idSinhVien,tenSinhVien
	FROM ThamGiaHoc JOIN lopHoc ON ThamGiaHoc.idLop = lopHoc.idLop 
	JOIN Sinh_Vien ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien 
	WHERE lopHoc.idLop = 16
	SELECT * FROM Diem

	SELECT Diem.maDiem,Mon_Hoc.tenMon,Mon_Hoc.maMon,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm
	FROM Diem JOIN Sinh_Vien ON Diem.idSinhVien = Sinh_Vien.idSinhVien 
	JOIN Mon_Hoc ON Diem.idMonHoc = Mon_Hoc.idMonHoc
	WHERE Sinh_Vien.idSinhVien = 1
SELECT * FROm Users
DELETE FRom Users WHERE username like 'dungbh@gmail.com' AND idGiangVien = 24

SELECT lopHoc.idLop,lopHoc.maLop,Nganh_Hep.tenNganhHep
	FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop 
	JOIN Giang_Vien ON Giang_Vien.idGiangVien = Phan_Cong.idGiangVien 
	JOIN Nganh_Hep on lopHoc.idNganhHep = Nganh_Hep.idNganhHep
	WHERE Giang_Vien.idGiangVien = 3
SELECT * FROM Giang_Vien
SELECT * FROM Phan_Cong
SELECT * FROM Mon_Hoc
DELETE  FROM lopHoc
select * from Diem
DELETE  FROM lopHoc
SELECT *  FROM Phan_Cong
DELETE FROM Diem
DELETE FROM ThamGiaHoc
INSERT INTO Phan_Cong(idLop,idMonHoc)
						values(19,33)
EXEC p_updateStudent 

SELECT ThamGiaHoc.idSinhVien,Phan_Cong.idMonHoc,Mon_Hoc.tenMon,Mon_Hoc.maMon,Phan_Cong.idGiangVien,lopHoc.idLop,Sinh_Vien.tenSinhVien,
Diem.lab1,Diem.lab2,Diem.lab3,Diem.lab4,diem.lab5,Diem.lab6,Diem.lab7,Diem.lab8,Diem.asm1,Diem.asm2,Diem.asmBaoVe,Diem.tbm
	FROM Phan_Cong JOIN lopHoc ON  lopHoc.idLop=Phan_Cong.idLop 
	JOIN ThamGiaHoc on lopHoc.idLop = ThamGiaHoc.idLop 
	JOIN Sinh_Vien ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien
	JOIN Mon_Hoc ON Phan_Cong.idMonHoc = Mon_Hoc.idMonHoc
	JOIN Diem on Sinh_Vien.idSinhVien = Diem.idSinhVien
	GROUP BY ThamGiaHoc.idSinhVien,Phan_Cong.idMonHoc,Mon_Hoc.tenMon,Mon_Hoc.maMon,Phan_Cong.idGiangVien,lopHoc.idLop,Sinh_Vien.tenSinhVien,
Diem.lab1,Diem.lab2,Diem.lab3,Diem.lab4,diem.lab5,Diem.lab6,Diem.lab7,Diem.lab8,Diem.asm1,Diem.asm2,Diem.asmBaoVe,Diem.tbm,Mon_Hoc.idMonHoc
	HAVING lopHoc.idLop = 24 AND Phan_Cong.idGiangVien =1 AND Mon_Hoc.idMonHoc =56
 SELECT * FROM lopHoc

SELECT Sinh_Vien.idSinhVien,tenSinhVien,Mon_Hoc.maMon,Mon_Hoc.idMonHoc,Mon_Hoc.tenMon,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm,lopHoc.idLop
	FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop 
		 JOIN ThamGiaHoc ON ThamGiaHoc.idLop = ThamGiaHoc.idLop
		 JOIN Sinh_Vien ON ThamGiaHoc.idSinhVien = Sinh_Vien.idSinhVien 
		 JOIN Diem on Sinh_Vien.idSinhVien = Diem.idSinhVien 
		 JOIN Mon_Hoc ON Diem.idMonHoc = Mon_Hoc.idMonHoc
	WHERE Phan_Cong.idGiangVien = 5 AND lopHoc.idLop=24 AND Diem.idMonHoc = 33
	SELECT * FROM Mon_Hoc

	SELECT lopHoc.idLop,lopHoc.maLop,Nganh_Hep.tenNganhHep,Phan_Cong.idMonHoc,Mon_Hoc.tenMon
                        	FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop 
                        	JOIN Giang_Vien ON Giang_Vien.idGiangVien = Phan_Cong.idGiangVien 
                        	JOIN Nganh_Hep on lopHoc.idNganhHep = Nganh_Hep.idNganhHep 
							JOIN Mon_Hoc on Phan_Cong.idMonHoc = Mon_Hoc.idMonHoc
                        	WHERE Giang_Vien.idGiangVien =1

UPDATE Diem SET lab1 =10 ,lab2=10,lab3=10,lab4=10,lab5=10,lab6=10,lab7=0,lab8=10,asm1=10,asm2=10,asmBaoVe=10
		WHERE  Diem.idMonHoc = 56 AND Diem.idSinhVien = 1
SELECT * FROM Mon_Hoc

CREATE OR ALTER TRIGGER trg_AfterInsertPhanCong
ON Phan_Cong
AFTER INSERT
AS
BEGIN
    -- Insert dữ liệu vào bảng Diem
    INSERT INTO Diem (idSinhVien, idMonHoc,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm)
    SELECT ThamGiaHoc.idSinhVien, inserted.idMonHoc,0,0,0,0,0,0,0,0,0,0,0,0
    FROM ThamGiaHoc
    INNER JOIN inserted ON ThamGiaHoc.idLop = inserted.idLop;
END;



DELETE  FROM ThamGiaHoc
DELETE FROM lopHoc
DELETE FROM Phan_Cong
SELECT *  FROM Mon_Hoc
UPDATE Diem SET tbm = 0
SELECT Sinh_Vien.idSinhVien,tenSinhVien,Mon_Hoc.maMon,Mon_Hoc.idMonHoc,Mon_Hoc.tenMon,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm
	FROM Phan_Cong JOIN lopHoc on Phan_Cong.idLop = lopHoc.idLop 
		 JOIN ThamGiaHoc ON ThamGiaHoc.idLop = ThamGiaHoc.idLop
		 JOIN Sinh_Vien ON ThamGiaHoc.idSinhVien = Sinh_Vien.idSinhVien 
		 JOIN Diem on Sinh_Vien.idSinhVien = Diem.idSinhVien 
		 JOIN Mon_Hoc ON Diem.idMonHoc = Mon_Hoc.idMonHoc
	WHERE Phan_Cong.idGiangVien = 5 AND lopHoc.idLop=25 AND Diem.idMonHoc = ?

SELECT  Diem.idSinhVien,Sinh_Vien.tenSinhVien,Phan_Cong.idMonHoc,Phan_Cong.idLop,
	lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm
	FROM Giang_Vien JOIN Phan_Cong ON Giang_Vien.idGiangVien = Phan_Cong.idGiangVien
	JOIN ThamGiaHoc ON Phan_Cong.idLop = ThamGiaHoc.idLop 
	JOIN Sinh_Vien on Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien JOIN Diem ON Sinh_Vien.idSinhVien = Diem.idSinhVien
	GROUP BY Phan_Cong.idGiangVien,Giang_Vien.tenGiangVien,Sinh_Vien.tenSinhVien,Phan_Cong.idMonHoc,Phan_Cong.idLop,
	lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm,ThamGiaHoc.idLop,Diem.idSinhVien
	HAVING Phan_Cong.idGiangVien = 5 AND Phan_Cong.idMonHoc=33 AND ThamGiaHoc.idLop = 28 


	SELECT Diem.idSinhVien,Sinh_Vien.tenSinhVien,Phan_Cong.idLop,Phan_Cong.idMonHoc,Phan_Cong.idGiangVien
		FROM Phan_Cong JOIN ThamGiaHoc on Phan_Cong.idLop =ThamGiaHoc.idLop 
	JOIN Sinh_Vien ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien JOIN Diem ON Diem.idSinhVien = Sinh_Vien.idSinhVien
	GROUP BY Diem.idSinhVien,Sinh_Vien.tenSinhVien,Phan_Cong.idLop,Phan_Cong.idMonHoc,Phan_Cong.idGiangVien

CREATE FUNCTION GetStudentDetailsForMark()
RETURNS TABLE
AS
RETURN
(
    SELECT Diem.idSinhVien, Sinh_Vien.tenSinhVien, Phan_Cong.idLop, Phan_Cong.idMonHoc, Phan_Cong.idGiangVien
    FROM Phan_Cong
    JOIN ThamGiaHoc ON Phan_Cong.idLop = ThamGiaHoc.idLop 
    JOIN Sinh_Vien ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien 
    JOIN Diem ON Diem.idSinhVien = Sinh_Vien.idSinhVien
    GROUP BY Diem.idSinhVien, Sinh_Vien.tenSinhVien, Phan_Cong.idLop, Phan_Cong.idMonHoc, Phan_Cong.idGiangVien
);
SELECT * FROm GetStudentDetailsForMark() AS details JOIN Diem on Diem.idMonHoc = details.idMonHoc
	WHERE details.idGiangVien = 5 AND details.idLop= 29 AND details.idMonHoc = 33

	SELECT Diem.idSinhVien,ThamGiaHoc.idLop,tenSinhVien,Diem.idMonHoc,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm FROm Diem 
	JOIN Sinh_Vien ON Diem.idSinhVien = Sinh_Vien.idSinhVien 
	JOIN ThamGiaHoc  ON Sinh_Vien.idSinhVien = ThamGiaHoc.idSinhVien JOIN Phan_Cong on ThamGiaHoc.idLop  = Phan_Cong.idLop
	GROUP BY  ThamGiaHoc.idLop,tenSinhVien,Diem.idMonHoc,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,asm1,asm2,asmBaoVe,tbm,Phan_Cong.idGiangVien,Diem.idSinhVien
	HAVING Phan_Cong.idGiangVien = 5 AND Diem.idMonHoc = 33 AND ThamGiaHoc.idLop = 28
GO

CREATE OR ALTER TRIGGER tr_Chk_Update_idNganh_idNganhHep
ON Sinh_Vien
INSTEAD OF UPDATE
AS
BEGIN
    -- Nếu có bất kỳ yêu cầu cập nhật trường "idNganhHep" hoặc "idNganh"
    IF UPDATE(idNganhHep) OR UPDATE(idNganh)
    BEGIN
        -- Lấy giá trị cũ của idNganh và idNganhHep từ bản ghi gốc
        DECLARE @old_idNganh int;
        DECLARE @old_idNganhHep int;
        SELECT @old_idNganh = idNganh, @old_idNganhHep = idNganhHep FROM deleted;

        -- Lấy giá trị mới của idNganh và idNganhHep từ bản ghi cập nhật
        DECLARE @new_idNganh int;
        DECLARE @new_idNganhHep int;
        SELECT @new_idNganh = idNganh, @new_idNganhHep = idNganhHep FROM inserted;

        -- Nếu giá trị mới của idNganh và idNganhHep khác giá trị cũ
        IF (EXISTS (SELECT 1 FROM ThamGiaHoc WHERE idSinhVien IN (SELECT idSinhVien FROM inserted)))
        BEGIN
			IF ( @new_idNganh <> @old_idNganh OR @new_idNganhHep <> @old_idNganhHep)
				BEGIN
				            RAISERROR('Không được cập nhật idNganh và idNganhHep với giá trị khác với bản ghi gốc', 16, 1)
            ROLLBACK TRANSACTION; -- Hoàn tác giao dịch nếu có lỗi
            RETURN;
			END
        END
    END
    UPDATE sv
    SET sv.tenSinhVien = i.tenSinhVien,
        sv.idNganhHep = i.idNganhHep,
        sv.idNganh = i.idNganh,
        sv.gioiTinh = i.gioiTinh,
        sv.sdt = i.sdt,
        sv.diaChi = i.diaChi,
        sv.email = i.email,
        sv.hinhAnh = i.hinhAnh
    FROM Sinh_Vien sv
    INNER JOIN inserted i ON sv.idSinhVien = i.idSinhVien;
END;
GO
CREATE OR ALTER TRIGGER tr_Update_idNganh_GiangVien
ON Giang_Vien
INSTEAD OF UPDATE
AS
BEGIN
    -- Nếu có bất kỳ yêu cầu cập nhật trường "idNganh"
    IF UPDATE(idNganh)
    BEGIN
        -- Kiểm tra xem idGiangVien đã tồn tại trong bảng Phan_Cong và giá trị mới của idNganh khác giá trị cũ
        IF EXISTS (
            SELECT 1
            FROM Phan_Cong pc
            INNER JOIN inserted i ON pc.idGiangVien = i.idGiangVien
            INNER JOIN deleted d ON pc.idGiangVien = d.idGiangVien
            WHERE i.idNganh <> d.idNganh
        )
        BEGIN
            RAISERROR('Không được cập nhật idNganh với giá trị khác với bản ghi gốc khi idGiangVien đã tồn tại trong bảng Phan_Cong', 16, 1)
            ROLLBACK TRANSACTION; -- Hoàn tác giao dịch nếu có lỗi
            RETURN;
        END
    END

    -- Nếu không có yêu cầu cập nhật trường "idNganh"
    -- Thực hiện việc cập nhật bình thường
    UPDATE gv
    SET gv.tenGiangVien = i.tenGiangVien,
        gv.idNganh = i.idNganh,
        gv.sdt = i.sdt,
        gv.email = i.email,
        gv.gioiTinh = i.gioiTinh,
        gv.hinhAnh = i.hinhAnh,
        gv.diaChi = i.diaChi
    FROM Giang_Vien gv
    INNER JOIN inserted i ON gv.idGiangVien = i.idGiangVien;
END;

