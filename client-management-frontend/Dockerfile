# Use an official node image as a base image
FROM node:14-alpine

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the React app
RUN npm run build

# Serve the React app using serve
RUN npm install -g serve
CMD ["serve", "-s", "build"]

# Expose port 3000 to the outside world
EXPOSE 3000
