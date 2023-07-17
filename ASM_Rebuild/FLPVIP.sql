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
	idMonHoc INT CONSTRAINT FK_IDMonChoLop FOREIGN KEY(idMonHoc) REFERENCES Mon_Hoc(idMonHoc), 
	maMonHoc varchar(10)
);
create table Ky_hoc(
	idKy INT IDENTITY(1,1) PRIMARY KEY,
	maKy varchar(5) NOT NULL,
	tenKy varchar(20) NOT NULL,
);
GO
create table Phan_Cong(
	idPhanCong INT IDENTITY(1,1) PRIMARY KEY,
	idLop INT CONSTRAINT FK_IDLopPhanCong FOREIGN KEY(idLop) REFERENCES lopHoc(idLop), 
	idGiangVien INT CONSTRAINT FK_IDGiangVienPhanCong FOREIGN KEY(idGiangVien) REFERENCES Giang_Vien(idGiangVien), 
	idPhong INT CONSTRAINT FK_IDidPhongPhanCong FOREIGN KEY(idPhong) REFERENCES phongHoc(idPhong),
	idKy INT CONSTRAINT FK_IdKyHoPhanCongc FOREIGN KEY(idKy) REFERENCES Ky_hoc(idKy)
);
create table ThamGiaHoc(
	idThamGia INT IDENTITY(1,1) PRIMARY KEY,
	idPhanCong INT CONSTRAINT FK_IDSinhVienThamGia FOREIGN KEY(idPhanCong) REFERENCES Phan_Cong(idPhanCong),
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
Create trigger tg_updateMark On Diem
FOR update
AS
BEGIN
	DECLARE @mark float
	SELECT @mark = (lab1+lab2+lab3+lab4+lab5+lab6+lab7+lab8+asm1+asm2+asmBaoVe)/11 FROM  inserted
	INSERT INTO Diem(tbm)
		VALUES(@mark)
END
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
	@idMonHoc INT
AS
BEGIN
	INSERT INTO lopHoc(idMonHoc)
	VALUES(@idMonHoc);
END
GO
CREATE OR ALTER trigger tg_genSubjectCode ON lopHoc
for insert
AS
BEGIN
	DECLARE @subjectCode varchar(10),@idClass int,@classCode varchar(10),@idSubject int
	SELECT @idClass = idLop FROM inserted
	SELECT @idSubject = idMonHoc FROM inserted
	SELECT @subjectCode = maMon FROM Mon_Hoc WHERE idMonHoc = @idSubject
	SET @classCode = @subjectCode+'.'+CAST(@idClass AS varchar(5))
	UPDATE lopHoc SET maLop = @classCode WHERE idLop = @idClass
END
GO
EXEC p_insertClass 34; 
GO
SELECT  * FROM Mon_Hoc
SELECT * FROM lopHoc
ALTER TABLE lopHoc
	ADD maLop varchar(10)
GO
create or alter procedure p_insertPhanCong
 @idLop INT,@idGiangVien INT,@idPhong INT,@idKy INT
 AS
 BEGIN
	insert into Phan_Cong(idLop,idGiangVien,idPhong,idKy)
		values(@idLop,@idGiangVien,@idPhong,@idKy)
 END
GO
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
GO
create or alter trigger tg_autoInsertSubjectCode ON  Mon_Hoc
for insert
AS
BEGIN
	DECLARE @subJectId int,@maJorId int,@majorDetailsId int,@MajorDetailsCode varchar(5),@maMon nvarchar(20)
	SELECT @subJectId = idMonHoc,@maJorId=idNganh,@majorDetailsId=idNganhHep FROM inserted
	SELECT @MajorDetailsCode=maNganhHep FROM Nganh_Hep WHERE idNganhHep = @majorDetailsId
	print 'alo '+Cast(@majorDetailsId AS varchar);
	IF(@majorDetailsId is not null)
	BEGIN
		SET @maMon =@MajorDetailsCode+CAST(@maJorId AS varchar(5))+CAST(@majorDetailsId AS varchar(5))+CAST(@subJectId AS varchar(5))
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
	SELECT maLop FROM lopHoc JOIN Mon_Hoc ON lopHoc.idMonHoc = 
);