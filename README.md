# Subscription Service

## 🎯 Purpose
The **Subscription Service** manages user billing plans, payment status, and verification of access rights. It determines whether a user is allowed to view premium media on the platform based on their active subscription.

## 🧑‍💻 Developer Guidelines
1. **API Responses**: ALL endpoints MUST return responses wrapped in the `ApiResponse<T>` class located in `dto/ApiResponse.java`. 
2. **Exceptions**: Throw `ResourceNotFoundException`, `BadRequestException`, or `DuplicateResourceException` when business rules are violated. The `GlobalExceptionHandler` will catch these automatically.
3. **Database**: We are using PostgreSQL. The credentials and port (`5435`) are injected via the Config Server. Do not hardcode them.
4. **Validation**: Validate incoming payloads with `jakarta.validation` annotations (`@NotNull`, `@Future`, etc.).

---

## 🏗️ Data Models (Entities & Enums)

You need to implement the following entities and enums.

### 1. `Plan` (Enum)
The tier of the subscription.
* `BASIC` (Ads, 720p)
* `PREMIUM` (No Ads, 1080p)
* `PRO` (No Ads, 4K, 4 Screens)

### 2. `SubscriptionStatus` (Enum)
Current status of the user's billing cycle.
* `ACTIVE`, `CANCELLED`, `EXPIRED`, `PENDING_PAYMENT`

### 3. `Subscription` (Entity)
Represents a user's subscription record. *This should not duplicate the User entity, only reference `userId`.*
* `id` (UUID or Long, Primary Key)
* `userId` (Foreign Key referencing User from `user-service`, Not Null)
* `planType` (Plan Enum)
* `status` (SubscriptionStatus Enum, Default: `ACTIVE`)
* `price` (BigDecimal or Double)
* `startDate` (LocalDateTime)
* `endDate` (LocalDateTime)
* `createdAt` (LocalDateTime)
* `updatedAt` (LocalDateTime)

---

## 🛣️ Required Endpoints (CRUD & Verification)
You must implement a Controller with the following standard operations:
* `POST /api/v1/subscriptions` - Create a new subscription for a user
* `GET /api/v1/subscriptions/{id}` - Get subscription details by ID
* `GET /api/v1/subscriptions/user/{userId}` - Get all subscriptions or active subscription for a specific user
* `PUT /api/v1/subscriptions/{id}/cancel` - Cancel an active subscription
* `GET /api/v1/subscriptions/user/{userId}/active` - **Crucial**: Verify if a user has an active subscription right now (returns Boolean or simple status)
