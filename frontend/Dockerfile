# Base stage
FROM node:18-alpine AS base
WORKDIR /app
COPY package*.json ./
RUN npm install

# Builder stage
FROM base AS builder
COPY . .
RUN npm run build

# Production stage
FROM base AS production
ENV NODE_ENV=production
EXPOSE 5000
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/package.json ./package.json
CMD ["npm", "start"]

# Development stage
FROM base AS dev
ENV NODE_ENV=development
EXPOSE 5000
COPY . .
CMD ["npm", "run", "dev"]