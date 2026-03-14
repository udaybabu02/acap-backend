
# ACAP Backend (Spring Boot 3 / Java 21)

## Run (dev)
```bash
./mvnw spring-boot:run
```

API base: `http://localhost:8080/api`

### Endpoints (starter)
- `POST /api/exams/start?subject=Java` → 100 randomized questions from the subject pool
- `POST /api/exams/submit` { "answers": { "1":"A", ... } } → `{ score: 85 }`
- `POST /api/questions/bulk` (multipart CSV)
- `GET /api/results/me` → results for userId=1

Swagger UI: `/swagger-ui/index.html`

### Database
- Uses **H2 in-memory** for dev. Switch to Postgres/MySQL by updating `spring.datasource.*` in `application.yml`.

### Next steps
- Add proper authentication (JWT, roles: ADMIN/STUDENT)
- Store exam sessions per user; move userId from hardcoded `1L` to authenticated principal
- Add exports (Excel/PDF) and admin analytics
