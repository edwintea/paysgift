# Base stage
FROM node:18-alpine as base
WORKDIR /app
COPY package*.json ./
RUN npm install

# Builder stage
FROM base as builder
COPY . .
RUN npm run build

# Production stage
FROM base as production
ENV NODE_ENV=production
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/package.json ./package.json
CMD ["npm", "start"]

# Development stage
FROM base as dev
ENV NODE_ENV=development
COPY . .
CMD ["npm", "run", "dev"]