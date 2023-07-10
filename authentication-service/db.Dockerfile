FROM postgres:latest
EXPOSE 25432
COPY db.sh .
RUN chmod +x db.sh