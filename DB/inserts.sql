USE [ASSA_BD]
GO

--Insertar Roles
INSERT INTO [dbo].[ROL] ([Descripcion]) VALUES ('Administrador'),('Empleado'),('Cliente')
GO

--Insertar Tipos de Identificación
INSERT INTO [dbo].[TIPO_IDENTIFICACION] ([Descripcion]) VALUES ('Cédula de Identidad'),('Pasaporte'),('Cédula de Residencia')
GO
 
--Insertar Tipos de Dirección
INSERT INTO [dbo].[TIPO_DIRECCION] ([Descripcion]) VALUES ('Principal'),('Entrega')
GO

-- Insertar Tipos de Pago
INSERT INTO [dbo].[TIPO_PAGO] ([Descripcion]) VALUES ('Efectivo'),('Tarjeta Débito'),('Tarjeta Crédito'),('Cheque')
GO

-- Insertar Tipos de Teléfono
INSERT INTO [dbo].[TIPO_TELEFONO] ([Descripcion]) VALUES ('Casa'),('Celular'),('Trabajo')
GO

-- Insertar Productos
INSERT INTO [dbo].[PRODUCTO]([Nombre],[Cantidad_Min_Compra],[Precio],[Fotografia],[Estado],
			[Id_Usu_Registra],[Fecha_Registra],[Id_Usu_Edita],[Fecha_Edita])
	VALUES
			('Tacos',10,2500.0,null,1,0,'2019-04-19 17:30:45',0,'2019-04-19 19:00:45'),
			('Gallo Pinto',1,1500.0,null,1,0,'2019-04-19 17:35:15',0,'2019-04-19 17:35:15'),
			('Sopa de Pollo',2,750.0,null,1,0,'2019-04-19 18:10:40',0,'2019-04-19 18:10:40'),
			('Filets de Tilapia',15,5000.0,null,1,0,'2019-04-19 18:20:20',0,'2019-04-19 18:20:20')
GO

--Insertar Usuarios de Prueba
INSERT INTO [dbo].[PERSONA] ([ID_TIPO_IDENTIFICACION],[Identificacion],[Nombre],[P_Apellido],[S_Apellido]
           ,[Contrasenna],[ID_ROL],[Estado],[Id_Usu_Registra],[Fecha_Registra],[Id_Usu_Edita],[Fecha_Edita])
     VALUES
           (1,111111111,'Admin','1','1','12345678',1,1,0,'2019-04-19 17:30:45',0,'2019-04-19 17:30:45'),
           (1,122222222,'Empleado','1','1','12345678',2,1,0,'2019-04-19 17:31:45',0,'2019-04-19 17:31:45'),
		   (1,133333333,'Admin','1','1','12345678',3,1,0,'2019-04-19 17:32:45',0,'2019-04-19 17:32:45')
GO

-- Insertar Correos
INSERT INTO [dbo].[CORREO] ([Correo],[Id_Usu_Registra],[Fecha_Registra],[Id_Usu_Edita],[Fecha_Edita])
     VALUES ('admin@test1.com',0,'2019-04-19 18:30:45',0,'2019-04-19 18:30:45'),
			('admin@test2.com',0,'2019-04-19 18:31:45',0,'2019-04-19 18:31:45'),
			('empleado@test1.com',0,'2019-04-19 18:32:45',0,'2019-04-19 18:32:45'),
			('empleado@test1.com',0,'2019-04-19 18:33:45',0,'2019-04-19 18:33:45'),
			('cliente@test1.com',0,'2019-04-19 18:34:45',0,'2019-04-19 18:34:45'),
			('cliente@test1.com',0,'2019-04-19 18:35:45',0,'2019-04-19 18:35:45')
GO

-- Relacionar Correos con Personas
INSERT INTO [dbo].[PERSONA_CORREO] ([ID_PERSONA],[ID_CORREO])
     VALUES (1,1),(1,2),(2,3),(2,4),(3,5),(3,6)
GO

-- Insertar Teléfonos
INSERT INTO [dbo].[TELEFONO]([Numero],[ID_TIPO_TELEFONO],[Id_Usu_Registra],[Fecha_Registra],[Id_Usu_Edita],[Fecha_Edita])
     VALUES ('11111111',1,0,'2019-04-19 18:40:45',0,'2019-04-19 18:40:45'),
			('22222222',2,0,'2019-04-19 18:41:45',0,'2019-04-19 18:41:45'),
			('33333333',3,0,'2019-04-19 18:42:45',0,'2019-04-19 18:42:45'),
			('44444444',1,0,'2019-04-19 18:43:45',0,'2019-04-19 18:43:45'),
			('55555555',2,0,'2019-04-19 18:44:45',0,'2019-04-19 18:44:45'),
			('66666666',3,0,'2019-04-19 18:45:45',0,'2019-04-19 18:45:45'),
			('77777777',1,0,'2019-04-19 18:46:45',0,'2019-04-19 18:46:45'),
			('88888888',2,0,'2019-04-19 18:47:45',0,'2019-04-19 18:47:45'),
			('99999999',3,0,'2019-04-19 18:48:45',0,'2019-04-19 18:48:45')
GO


DBCC CHECKIDENT ('TELEFONO');--, RESEED, 0);
-- Relacionar Telefonos con Personas
INSERT INTO [dbo].[PERSONA_TELEFONO] ([ID_PERSONA],[ID_TELEFONO])
     VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9)
GO

