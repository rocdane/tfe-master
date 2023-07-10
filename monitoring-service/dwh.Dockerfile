FROM postgres:latest
COPY dwh.sh /tmp
WORKDIR /tmp
CMD ["sh","-c","chmod +x dwh.sh && ./dwh.sh"]