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
	maMon varchar(5) NOT NULL
);
	GO
create table Sinh_Vien(
	idSinhVien INT IDENTITY(1,1) PRIMARY KEY,
	tenSinhVien nvarchar(25) NOT NULL,
	idNganh  int CONSTRAINT FK_maNganhSV FOREIGN KEY (idNganh) REFERENCES Chuyen_Nganh(idNganh) NOT NULL,
	idNganhHep int CONSTRAINT FK_maNganHepSV FOREIGN KEY (idNganhHep) REFERENCES  Nganh_Hep(idNganhHep),
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
	username varchar(20) PRIMARY  KEY,
	password varchar(20) NOT NULL,
	idCanBo INT CONSTRAINT FK_IDCanBo FOREIGN KEY(idCanBo) REFERENCES Can_Bo_Dao_tao(idCanBo),
	idGiangVien INT CONSTRAINT FK_IDGiangVien FOREIGN KEY(idGiangVien) REFERENCES Giang_Vien(idGiangVien), 
	idSinhVien INT CONSTRAINT FK_IDSinhVien FOREIGN KEY(idSinhVien) REFERENCES  Sinh_Vien(idSinhVien)
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
	idSinhVien INT CONSTRAINT FK_IDSinhVienPhanCong FOREIGN KEY(idSinhVien) REFERENCES  Sinh_Vien(idSinhVien),
	idPhong INT CONSTRAINT FK_IDidPhongPhanCong FOREIGN KEY(idPhong) REFERENCES phongHoc(idPhong),
	idKy INT CONSTRAINT FK_IdKyHoPhanCongc FOREIGN KEY(idKy) REFERENCES Ky_hoc(idKy)
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
	@idNganh  int,@idNganhHep int,@tenMon nvarchar(20),@maMon varchar(5)
AS
BEGIN
	INSERT INTO  Mon_Hoc(idNganh,idNganhHep,tenMon,maMon)
	VALUES(@idNganh,@idNganhHep,@tenMon,@maMon);
END
GO
EXEC p_insertNganh 'IT',N'Công Nghệ Thông Tin';
EXEC p_insertNganhHep 1,'SD',N'Phát triển phần mềm';
EXEC p_insertNganhHep 1,'WEB',N'Lập trình web';
EXEC p_insertNganhHep 1,'MOB',N'Lập trình Mobile';
EXEC p_insertNganhHep 1,'DAT',N'Xử lý dữ liệu';
EXEC p_insertNganhHep 1,'GAM',N'Lập trình Game';
GO
EXEC p_insertMonHoc  1,1,N'Lập trình Java 1','MOB 1024'

SELECT  Chuyen_Nganh.maNganh,Nganh_Hep.maNganhHep,Nganh_Hep.tenNganhHep 
	FROM  Nganh_Hep JOIN Chuyen_Nganh ON Nganh_Hep.idNganh = Chuyen_Nganh.idNganh