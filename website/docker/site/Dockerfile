FROM php:5.6-apache

RUN apt-get update && apt-get install -y zlib1g-dev

# Install PDO MySQL driver
# See https://github.com/docker-library/php/issues/62
RUN docker-php-ext-install pdo mysql
RUN docker-php-ext-install pdo mysqli
RUN docker-php-ext-install pdo pdo_mysql
RUN docker-php-ext-install mysql mysqli
RUN docker-php-ext-install zip

#RUN echo "file_uploads = On" > /usr/local/etc/php/conf.d/file_upload.ini

# Workaround for write permission on write to MacOS X volumes
# See https://github.com/boot2docker/boot2docker/pull/534
RUN usermod -u 1000 www-data
 
# Enable Apache mod_rewrite
RUN a2enmod rewrite