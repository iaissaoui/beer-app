# Stage 1
FROM node:15.5.0-alpine as build-step
RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
RUN npm run build
#--prod
# Stage 2
FROM nginx:1.19.6-alpine
RUN rm /etc/nginx/conf.d/default.conf
COPY docker/nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build-step /app/dist/demo-ng /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
