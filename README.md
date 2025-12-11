#Overview
This README documents the implementation of TP 3: Securing an E-Learning Application using OAuth2 and OpenID Connect (OIDC) with Keycloak as the identity server, Spring Boot as the backend API, and React as the frontend SPA. The goal is to create a secure platform where:

STUDENT users can view courses.
ADMIN users can manage (view and add) courses.

The application enforces role-based access control (RBAC), single sign-on (SSO), and token-based authentication.
## 🧱 Architecture

```text
elearning-project/
├── backend/                  # Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/elearning/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── application.yml
│
├── frontend/                 # React frontend
│   ├── src/
│   │   ├── components/
│   │   ├── App.js
│   │   └── index.js
│   ├── package.json
│   └── vite.config.js        # or configuration file for CRA
│
├── keycloak/                 # Keycloak realm/exported configuration
│
├── docs/
│   └── architecture.md       # Documentation about the system architecture
│
└── README.md                 # Main documentation file
