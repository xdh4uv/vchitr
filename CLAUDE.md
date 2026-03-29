# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

```bash
# Build
./mvnw clean package

# Build (skip tests)
./mvnw clean package -DskipTests

# Run application
./mvnw spring-boot:run

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=ClassName

# Run a single test method
./mvnw test -Dtest=ClassName#methodName
```

## Architecture Overview

**vchitr** is a Spring Boot 3.x educational web platform ("Absorb the concepts, don't cram"). Java 25, deployed to Google Cloud Run via GitHub Actions on push to `master`.

### Layer Structure
```
com.vchitr/
├── controller/    # REST endpoints
├── entity/        # JPA entities (mapped to PostgreSQL schema)
├── repository/    # Spring Data JPA repositories
└── security/      # Spring Security configuration
```

### Key Design Decisions

- **Database schema:** Entities live in the `security` schema (e.g., `security.users`). DDL is auto-managed (`ddl-auto=update`).
- **Authentication:** Supports two providers via the `authProviders` enum: `LOCAL` (email/password) and `GOOGLE` (OAuth2). User roles are `ADMIN`, `STUDENT`, `TEACHER`.
- **Database:** Neon serverless PostgreSQL (AWS ap-southeast-1). Connection requires `sslmode=require&channelBinding=require`.
- **DataSource autoconfigure is excluded** in `application.properties` — datasource config is done manually via properties.

### Deployment

- CI/CD: `.github/workflows/deploy.yml` triggers on `master` push, builds Docker image, pushes to Google Artifact Registry, deploys to Cloud Run (asia-south1).
- Multi-stage `Dockerfile`: Maven build stage → eclipse-temurin:25-jre-alpine runtime, port 8080.
- Secrets (DB credentials, OAuth keys) are injected as environment variables at Cloud Run deploy time — they are not in `application.properties`.
