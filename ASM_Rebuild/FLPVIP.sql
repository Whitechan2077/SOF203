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
	maMon varchar(10) NOT NULL
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
create or alter PROCEDURE p_insertNganh
	@maNganh varchar(5),@tenNganh nvarchar(20)
AS
BEGIN
	INSERT INTO Chuyen_Nganh(maNganh,tenNganh)
	VALUES(@maNganh,@tenNganh);
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
	@idNganh  int,@idNganhHep int,@tenMon nvarchar(20),@maMon varchar(10)
AS
BEGIN
	INSERT INTO  Mon_Hoc(idNganh,idNganhHep,tenMon,maMon)
	VALUES(@idNganh,@idNganhHep,@tenMon,@maMon);
END
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
insert into Ky_hoc ()
	VALUES();
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
EXEC p_updateStudent 'Bui Dung',1,2,'0397767819','Phú Thọ','dungbhphC@fpt.edu.vn',0011,1,1;
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
EXEC p_insertCanBo 'Bùi Hoàng Dũng','039487848','dungbh@gmail.com',0011000111,N''
GO
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
SELECT Giang_Vien.idGiangVien,Giang_Vien.tenGiangVien,Giang_Vien.gioiTinh,Giang_Vien.email,Giang_Vien.diaChi,Chuyen_Nganh.tenNganh,Giang_Vien.hinhAnh,Giang_Vien.sdt 
	FROM Giang_Vien JOIN Chuyen_Nganh ON Giang_Vien.idNganh = Chuyen_Nganh.idNganh
);
