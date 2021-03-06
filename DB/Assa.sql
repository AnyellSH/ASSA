USE [master]
GO
/****** Object:  Database [ASSA_BD]    Script Date: 22/3/2019 1:46:21 p. m. ******/
CREATE DATABASE [ASSA_BD]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ASSA_BD', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ASSA_BD.mdf' , SIZE = 204800KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ASSA_BD_LOG', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ASSA_BD_log.ldf' , SIZE = 2048KB , MAXSIZE = 4096000KB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ASSA_BD] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ASSA_BD].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ASSA_BD] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ASSA_BD] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ASSA_BD] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ASSA_BD] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ASSA_BD] SET ARITHABORT OFF 
GO
ALTER DATABASE [ASSA_BD] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ASSA_BD] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ASSA_BD] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ASSA_BD] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ASSA_BD] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ASSA_BD] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ASSA_BD] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ASSA_BD] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ASSA_BD] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ASSA_BD] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ASSA_BD] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ASSA_BD] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ASSA_BD] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ASSA_BD] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ASSA_BD] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ASSA_BD] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ASSA_BD] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ASSA_BD] SET RECOVERY FULL 
GO
ALTER DATABASE [ASSA_BD] SET  MULTI_USER 
GO
ALTER DATABASE [ASSA_BD] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ASSA_BD] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ASSA_BD] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ASSA_BD] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ASSA_BD] SET DELAYED_DURABILITY = DISABLED
GO
EXEC sys.sp_db_vardecimal_storage_format N'ASSA_BD', N'ON'
GO
USE [ASSA_BD]
GO
/****** Object:  Table [dbo].[TIPO_DIRECCION]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_DIRECCION](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ID_TIPO_DIRECCION] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PROVINCIAS]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PROVINCIAS](
	[COD_PROVINCIA] [numeric](1, 0) NOT NULL primary key,
	[DSC_CORTA_PROVINCIA] [nvarchar](255) NULL,
	[DSC_PROVINCIA] [nvarchar](255) NULL,
	[LOG_ACTIVO] [numeric](1, 0) NULL)

GO
/****** Object:  Table [dbo].[CANTONES]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CANTONES](
	[COD_PROVINCIA] [numeric](1, 0) NOT NULL references Provincias,
	[COD_CANTON] [numeric](2, 0) NOT NULL,
	[DSC_CANTON] [nvarchar](255) NULL,
	[LOG_ACTIVO] [numeric](1, 0) NULL,
	primary key(COD_PROVINCIA,COD_CANTON))


GO
/****** Object:  Table [dbo].[DISTRITOS]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DISTRITOS](
	[COD_PROVINCIA] [numeric](1, 0) NOT NULL,
	[COD_CANTON] [numeric](2, 0) NOT NULL,
	[COD_DISTRITO] [numeric](3, 0) NOT NULL,
	[DSC_DISTRITO] [nvarchar](255) NULL,
	[LOG_ACTIVO] [numeric](1, 0) NULL,
	foreign key (COD_PROVINCIA,COD_CANTON) references CANTONES,
	primary key(COD_PROVINCIA,COD_CANTON,COD_DISTRITO)
)

GO
/****** Object:  Table [dbo].[BARRIO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BARRIO](
	[COD_PROVINCIA] [numeric](1, 0) NOT NULL,
	[COD_CANTON] [numeric](2, 0) NOT NULL,
	[COD_DISTRITO] [numeric](3, 0) NOT NULL,
	[COD_BARRIO] [numeric](4, 0) NOT NULL,
	[DSC_BARRIO] [nvarchar](255) NULL,
	[LOG_ACTIVO] [numeric](1, 0) NULL,
	foreign key (COD_PROVINCIA,COD_CANTON,COD_DISTRITO) references DISTRITOS,
	primary key(COD_PROVINCIA,COD_CANTON,COD_DISTRITO,COD_BARRIO)
)

GO
/****** Object:  Table [dbo].[ACEPTACION_SOLICITUD]    Script Date: 22/3/2019 1:46:24 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ACEPTACION_SOLICITUD](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ID_ACEPTACION_SOLICITUD] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[BITACORA_DESPACHO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BITACORA_DESPACHO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Fecha] [date] NOT NULL,
	[ID_EMPLEADO] [numeric](2, 0) NOT NULL,
	[ID_ENCABEZADO_FACTURA] [numeric](2, 0) NOT NULL,
	[Medio_Despacho] [nvarchar](50) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_BITACORA_DESPACHO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[CORREO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CORREO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Correo] [nvarchar](50) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_CORREO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CUERPO_FACTURA]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CUERPO_FACTURA](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[ID_FACTURA] [numeric](2, 0) NOT NULL,
	[ID_SOLICITUD_PEDIDO] [numeric](2, 0) NOT NULL,
	[Direccion] [nvarchar](50) NOT NULL,
	[Cant_Facturar] [int] NOT NULL,
	[Descripcion] [nvarchar](100) NOT NULL,
	[Impuesto] [decimal](18, 0) NOT NULL,
	[Descuento] [decimal](18, 0) NOT NULL,
 CONSTRAINT [PK_ID_CUERPO_FACTURA] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DETALLE_FACTURA]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DETALLE_FACTURA](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Sut_total] [decimal](18, 0) NOT NULL,
	[Descuento_Total] [decimal](18, 0) NOT NULL,
	[Impuesto_Total] [decimal](18, 0) NOT NULL,
	[Total_Factura] [decimal](18, 0) NOT NULL,
	[Observacionces] [nvarchar](100) NOT NULL,
	[ID_CUERPO_FACTURA] [numeric](2, 0) NOT NULL,
 CONSTRAINT [PK_ID_DETALLE_FACTURA] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DIRECCION]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DIRECCION](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Otras_Sennas] [nvarchar](50) NOT NULL,
	[Horarios] [nvarchar](50) NOT NULL,
	[Estado] [numeric](2, 0) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
	[ID_TIPO_DIRECCION] [numeric](2, 0) NOT NULL,
	[COD_PROVINCIA] [numeric](1, 0) NOT NULL,
	[COD_CANTON] [numeric](2, 0) NOT NULL,
	[COD_DISTRITO] [numeric](3, 0) NOT NULL,
	[COD_BARRIO] [numeric](4, 0) NOT NULL,
	foreign key (COD_PROVINCIA,COD_CANTON,COD_DISTRITO,COD_BARRIO) references BARRIO,
	foreign key (ID_TIPO_DIRECCION) references TIPO_DIRECCION,
	primary key (Id)
)

GO

/****** Object:  Table [dbo].[ENCABEZADO_FACTURA]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ENCABEZADO_FACTURA](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Fecha] [date] NOT NULL,
	[ID_EMPLEADO] [numeric](2, 0) NOT NULL,
	[ID_NOMBRE_CLIENTE] [nvarchar](100) NOT NULL,
	[ID_CLIENTE] [nvarchar](50) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_ENCABEZADO_FACTURA] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MEDIO_DESPACHO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MEDIO_DESPACHO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
	[Estado] [numeric](2, 0) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_MEDIO_DESPACHO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PERFILES]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PERFILES](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
	[Estado] [numeric](2, 0) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_PERFILES] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PERSONA]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PERSONA](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[ID_TIPO_IDENTIFICACION] [numeric](2, 0) NOT NULL,
	[Identificacion] [nvarchar](25) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[P_Apellido] [nvarchar](50) NOT NULL,
	[S_Apellido] [nvarchar](50) NOT NULL,
	[Contrasenna] [nvarchar](50) NOT NULL,
	[ID_ROL] [numeric](2, 0) NOT NULL,
	[Estado] [numeric](2, 0) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_PERSONA] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PERSONA_CORREO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PERSONA_CORREO](
	[ID_PERSONA] [numeric](2, 0) NOT NULL,
	[ID_CORREO] [numeric](2, 0) NOT NULL,
 CONSTRAINT [PK_ID_PERSONA_CORREO] PRIMARY KEY CLUSTERED 
(
	[ID_PERSONA] ASC,
	[ID_CORREO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PERSONA_DIRECCION]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PERSONA_DIRECCION](
	[ID_PERSONA] [numeric](2, 0) NOT NULL,
	[ID_DIRECCION] [numeric](2, 0) NOT NULL,
 CONSTRAINT [PK_ID_PERSONA_DIRECCION] PRIMARY KEY CLUSTERED 
(
	[ID_PERSONA] ASC,
	[ID_DIRECCION] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PERSONA_TELEFONO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PERSONA_TELEFONO](
	[ID_PERSONA] [numeric](2, 0) NOT NULL,
	[ID_TELEFONO] [numeric](2, 0) NOT NULL,
 CONSTRAINT [PK_ID_PERSONA_TELEFONO] PRIMARY KEY CLUSTERED 
(
	[ID_PERSONA] ASC,
	[ID_TELEFONO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PRODUCTO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCTO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Nombre] [nvarchar](50) NOT NULL,
	[Cantidad_Min_Compra] [int] NOT NULL,
	[Precio] [decimal](18, 0) NOT NULL,
	[Fotografia] [nvarchar](100) NULL,
	[Estado] [numeric](2, 0) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PRODUCTO_SOLICITUD_PEDIDO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCTO_SOLICITUD_PEDIDO](
	[ID_PRODUCTO] [numeric](2, 0) NOT NULL,
	[ID_SOLICITUD_PEDIDO] [numeric](2, 0) NOT NULL,
 CONSTRAINT [PK_ID_PRODUCTO_SOLICITUD_PEDIDO] PRIMARY KEY CLUSTERED 
(
	[ID_PRODUCTO] ASC,
	[ID_SOLICITUD_PEDIDO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[ROL]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ROL](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ID_ROL] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SOLICITUD_PEDIDO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SOLICITUD_PEDIDO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Fecha] [date] NOT NULL,
	[ID_PERSONA] [numeric](2, 0) NOT NULL,
	[ID_DIRECCION] [numeric](2, 0) NOT NULL,
	[Cantidad] [int] NOT NULL,
	[ID_ACEPTACION_SOLICITUD] [numeric](2, 0) NOT NULL,
	[ID_MEDIO_DESPACHO] [numeric](2, 0) NOT NULL,
	[ID_TIPO_PAGO] [numeric](2, 0) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_SOLICITUD_PEDIDO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TELEFONO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TELEFONO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Numero] [nvarchar](50) NOT NULL,
	[ID_TIPO_TELEFONO] [numeric](2, 0) NOT NULL,
	[Id_Usu_Registra] [numeric](2, 0) NOT NULL,
	[Fecha_Registra] [date] NOT NULL,
	[Id_Usu_Edita] [numeric](2, 0) NOT NULL,
	[Fecha_Edita] [date] NOT NULL,
 CONSTRAINT [PK_ID_TELEFONO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TIPO_IDENTIFICACION]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_IDENTIFICACION](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ID_TIPO_IDENTIFICACION] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TIPO_PAGO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_PAGO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ID_TIPO_PAGO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TIPO_TELEFONO]    Script Date: 22/3/2019 1:46:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_TELEFONO](
	[Id] [numeric](2, 0) NOT NULL IDENTITY(1,1),
	[Descripcion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ID_TIPO_TELEFONO] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
--ALTER TABLE [dbo].[BARRIO]  WITH CHECK ADD  CONSTRAINT [FK_ID_BARRIO_DISTRITOS] FOREIGN KEY([COD_DISTRITO])
--REFERENCES [dbo].[DISTRITOS] ([COD_DISTRITO])
--GO
--ALTER TABLE [dbo].[BARRIO] CHECK CONSTRAINT [FK_ID_BARRIO_DISTRITOS]
--GO
ALTER TABLE [dbo].[BITACORA_DESPACHO]  WITH CHECK ADD  CONSTRAINT [FK_ID_BITACORA_DESPACHO_EMPLEADO] FOREIGN KEY([ID_EMPLEADO])
REFERENCES [dbo].[PERSONA] ([Id])
GO
ALTER TABLE [dbo].[BITACORA_DESPACHO] CHECK CONSTRAINT [FK_ID_BITACORA_DESPACHO_EMPLEADO]
GO
ALTER TABLE [dbo].[BITACORA_DESPACHO]  WITH CHECK ADD  CONSTRAINT [FK_ID_BITACORA_DESPACHO_ENCABEZADO_FACTURA] FOREIGN KEY([ID_ENCABEZADO_FACTURA])
REFERENCES [dbo].[ENCABEZADO_FACTURA] ([Id])
GO
ALTER TABLE [dbo].[BITACORA_DESPACHO] CHECK CONSTRAINT [FK_ID_BITACORA_DESPACHO_ENCABEZADO_FACTURA]
GO
--ALTER TABLE [dbo].[CANTONES]  WITH CHECK ADD  CONSTRAINT [FK_ID_CANTON_PROVINCIA] FOREIGN KEY([COD_PROVINCIA])
--REFERENCES [dbo].[PROVINCIAS] ([COD_PROVINCIA])
--GO
--ALTER TABLE [dbo].[CANTONES] CHECK CONSTRAINT [FK_ID_CANTON_PROVINCIA]
--GO
ALTER TABLE [dbo].[CUERPO_FACTURA]  WITH CHECK ADD  CONSTRAINT [FK_ID_CUERPO_FACTURA_ENCABEZADO_FACTURA] FOREIGN KEY([ID_FACTURA])
REFERENCES [dbo].[ENCABEZADO_FACTURA] ([Id])
GO
ALTER TABLE [dbo].[CUERPO_FACTURA] CHECK CONSTRAINT [FK_ID_CUERPO_FACTURA_ENCABEZADO_FACTURA]
GO
ALTER TABLE [dbo].[CUERPO_FACTURA]  WITH CHECK ADD  CONSTRAINT [FK_ID_CUERPO_FACTURA_SOLICITUD_PEDIDO] FOREIGN KEY([ID_SOLICITUD_PEDIDO])
REFERENCES [dbo].[SOLICITUD_PEDIDO] ([Id])
GO
ALTER TABLE [dbo].[CUERPO_FACTURA] CHECK CONSTRAINT [FK_ID_CUERPO_FACTURA_SOLICITUD_PEDIDO]
GO
ALTER TABLE [dbo].[DETALLE_FACTURA]  WITH CHECK ADD  CONSTRAINT [FK_ID_CUERPO_FACTURA_DETALLE_FACTURA] FOREIGN KEY([ID_CUERPO_FACTURA])
REFERENCES [dbo].[CUERPO_FACTURA] ([Id])
GO
ALTER TABLE [dbo].[DETALLE_FACTURA] CHECK CONSTRAINT [FK_ID_CUERPO_FACTURA_DETALLE_FACTURA]
GO
--ALTER TABLE [dbo].[DIRECCION]  WITH CHECK ADD  CONSTRAINT [FK_ID_DIRECCON_BARRIOS] FOREIGN KEY([ID_BARRIO])
--REFERENCES [dbo].[BARRIO] ([COD_BARRIO])
--GO
--ALTER TABLE [dbo].[DIRECCION] CHECK CONSTRAINT [FK_ID_DIRECCON_BARRIOS]
--GO
ALTER TABLE [dbo].[DIRECCION]  WITH CHECK ADD  CONSTRAINT [FK_ID_DIRECCON_TIPO_DIRECCION] FOREIGN KEY([ID_TIPO_DIRECCION])
REFERENCES [dbo].[TIPO_DIRECCION] ([Id])
GO
ALTER TABLE [dbo].[DIRECCION] CHECK CONSTRAINT [FK_ID_DIRECCON_TIPO_DIRECCION]
GO
--ALTER TABLE [dbo].[DISTRITOS]  WITH CHECK ADD  CONSTRAINT [FK_ID_DISTRITO_CANTON] FOREIGN KEY([COD_CANTON],[COD_PROVINCIA])
--REFERENCES [dbo].[CANTONES] ([COD_CANTON],[COD_PROVINCIA])
--GO
--ALTER TABLE [dbo].[DISTRITOS] CHECK CONSTRAINT [FK_ID_DISTRITO_CANTON]
GO
ALTER TABLE [dbo].[ENCABEZADO_FACTURA]  WITH CHECK ADD  CONSTRAINT [FK_ID_ENCABEZSADO_FACTURA_EMPLEADO] FOREIGN KEY([ID_EMPLEADO])
REFERENCES [dbo].[PERSONA] ([Id])
GO
ALTER TABLE [dbo].[ENCABEZADO_FACTURA] CHECK CONSTRAINT [FK_ID_ENCABEZSADO_FACTURA_EMPLEADO]
GO
ALTER TABLE [dbo].[PERSONA]  WITH CHECK ADD  CONSTRAINT [FK_ID_PERSONA_TIPO_IDENTIFICACION] FOREIGN KEY([ID_TIPO_IDENTIFICACION])
REFERENCES [dbo].[TIPO_IDENTIFICACION] ([Id])
GO
ALTER TABLE [dbo].[PERSONA] CHECK CONSTRAINT [FK_ID_PERSONA_TIPO_IDENTIFICACION]
GO
ALTER TABLE [dbo].[PERSONA]  WITH CHECK ADD  CONSTRAINT [FK_PERSONA_ROL] FOREIGN KEY([ID_ROL])
REFERENCES [dbo].[Rol] ([Id])
GO
ALTER TABLE [dbo].[PERSONA] CHECK CONSTRAINT [FK_ID_PERSONA_TIPO_IDENTIFICACION]
GO
--ALTER TABLE [dbo].[PERSONA]  WITH CHECK ADD  CONSTRAINT [FK_ID_PERSONA_IDENTIFICACION] FOREIGN KEY([ID_IDENTIFICACION])
--REFERENCES [dbo].[IDENTIFICACION] ([Id])
--GO
--ALTER TABLE [dbo].[PERSONA] CHECK CONSTRAINT [FK_ID_PERSONA_IDENTIFICACION]
--GO
ALTER TABLE [dbo].[PERSONA_CORREO]  WITH CHECK ADD  CONSTRAINT [FK_ID_CORREO_PERSONA_CORREO] FOREIGN KEY([ID_CORREO])
REFERENCES [dbo].[CORREO] ([Id])
GO
ALTER TABLE [dbo].[PERSONA_CORREO] CHECK CONSTRAINT [FK_ID_CORREO_PERSONA_CORREO]
GO
ALTER TABLE [dbo].[PERSONA_CORREO]  WITH CHECK ADD  CONSTRAINT [FK_ID_PERSONA_PERSONA_CORREO] FOREIGN KEY([ID_PERSONA])
REFERENCES [dbo].[PERSONA] ([Id])
GO
ALTER TABLE [dbo].[PERSONA_CORREO] CHECK CONSTRAINT [FK_ID_PERSONA_PERSONA_CORREO]
GO
ALTER TABLE [dbo].[PERSONA_DIRECCION]  WITH CHECK ADD  CONSTRAINT [FK_ID_DIRECCION_PERSONA_DIRECCION] FOREIGN KEY([ID_DIRECCION])
REFERENCES [dbo].[DIRECCION] ([Id])
GO
ALTER TABLE [dbo].[PERSONA_DIRECCION] CHECK CONSTRAINT [FK_ID_DIRECCION_PERSONA_DIRECCION]
GO
ALTER TABLE [dbo].[PERSONA_DIRECCION]  WITH CHECK ADD  CONSTRAINT [FK_ID_PERSONA_PERSONA_DIRECCION] FOREIGN KEY([ID_PERSONA])
REFERENCES [dbo].[PERSONA] ([Id])
GO
ALTER TABLE [dbo].[PERSONA_DIRECCION] CHECK CONSTRAINT [FK_ID_PERSONA_PERSONA_DIRECCION]
GO
ALTER TABLE [dbo].[PERSONA_TELEFONO]  WITH CHECK ADD  CONSTRAINT [FK_ID_PERSONA_PERSONA_TELEFONO] FOREIGN KEY([ID_PERSONA])
REFERENCES [dbo].[PERSONA] ([Id])
GO
ALTER TABLE [dbo].[PERSONA_TELEFONO] CHECK CONSTRAINT [FK_ID_PERSONA_PERSONA_TELEFONO]
GO
ALTER TABLE [dbo].[PERSONA_TELEFONO]  WITH CHECK ADD  CONSTRAINT [FK_ID_TELEFONO_PERSONA_TELEFONO] FOREIGN KEY([ID_TELEFONO])
REFERENCES [dbo].[TELEFONO] ([Id])
GO
ALTER TABLE [dbo].[PERSONA_TELEFONO] CHECK CONSTRAINT [FK_ID_TELEFONO_PERSONA_TELEFONO]
GO
ALTER TABLE [dbo].[PRODUCTO_SOLICITUD_PEDIDO]  WITH CHECK ADD  CONSTRAINT [FK_ID_PRODUCTO_PEDIDO_PRODUCTO] FOREIGN KEY([ID_PRODUCTO])
REFERENCES [dbo].[PRODUCTO] ([Id])
GO
ALTER TABLE [dbo].[PRODUCTO_SOLICITUD_PEDIDO] CHECK CONSTRAINT [FK_ID_PRODUCTO_PEDIDO_PRODUCTO]
GO
ALTER TABLE [dbo].[PRODUCTO_SOLICITUD_PEDIDO]  WITH CHECK ADD  CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_PRODUCTO_SOLICITUD_PEDIDO] FOREIGN KEY([ID_SOLICITUD_PEDIDO])
REFERENCES [dbo].[SOLICITUD_PEDIDO] ([Id])
GO
ALTER TABLE [dbo].[PRODUCTO_SOLICITUD_PEDIDO] CHECK CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_PRODUCTO_SOLICITUD_PEDIDO]
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO]  WITH CHECK ADD  CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_ACEPTACION_SOLICITUD] FOREIGN KEY([ID_ACEPTACION_SOLICITUD])
REFERENCES [dbo].[ACEPTACION_SOLICITUD] ([Id])
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO] CHECK CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_ACEPTACION_SOLICITUD]
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO]  WITH CHECK ADD  CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_DIRECCION] FOREIGN KEY([ID_DIRECCION])
REFERENCES [dbo].[DIRECCION] ([Id])
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO] CHECK CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_DIRECCION]
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO]  WITH CHECK ADD  CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_MEDIO_DESPACHO] FOREIGN KEY([ID_MEDIO_DESPACHO])
REFERENCES [dbo].[MEDIO_DESPACHO] ([Id])
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO] CHECK CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_MEDIO_DESPACHO]
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO]  WITH CHECK ADD  CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_PERSONA] FOREIGN KEY([ID_PERSONA])
REFERENCES [dbo].[PERSONA] ([Id])
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO] CHECK CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_PERSONA]
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO]  WITH CHECK ADD  CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_TIPO_PAGO] FOREIGN KEY([ID_TIPO_PAGO])
REFERENCES [dbo].[TIPO_PAGO] ([Id])
GO
ALTER TABLE [dbo].[SOLICITUD_PEDIDO] CHECK CONSTRAINT [FK_ID_SOLICITUD_PEDIDO_TIPO_PAGO]
GO
ALTER TABLE [dbo].[TELEFONO]  WITH CHECK ADD  CONSTRAINT [FK_ID_TELEFONO_TIPO_TELEFONO] FOREIGN KEY([ID_TIPO_TELEFONO])
REFERENCES [dbo].[TIPO_TELEFONO] ([Id])
GO
ALTER TABLE [dbo].[TELEFONO] CHECK CONSTRAINT [FK_ID_TELEFONO_TIPO_TELEFONO]
GO
USE [master]
GO
ALTER DATABASE [ASSA_BD] SET  READ_WRITE 
GO
