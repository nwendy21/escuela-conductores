# Despliegue gratuito

## 1. Base de datos (Aiven MySQL o TiDB Cloud)
Crea un MySQL gratis y copia host, puerto, usuario, contraseña y nombre de la BD.

## 2. Backend (Render -> New Web Service -> Docker)
- Root Directory: backend/api-escuelaConductores
- Variables de entorno:
  MYSQL_SERVICE, MYSQL_PORT, MYSQL_DB, MYSQL_USER, MYSQL_PASSWORD
  CORS_ORIGINS = https://tu-frontend.vercel.app
  SHOW_SQL = false

## 3. Frontend (Vercel)
- Root Directory: fronted/app-conductores
- Build command: npm run build
- Output directory: dist/app-conductores/browser
- Antes: edita src/environments/environment.ts con la URL del backend.

Orden: BD -> backend -> editar environment.ts -> frontend -> poner URL del frontend en CORS_ORIGINS.
