#!/bin/bash
URL="http://localhost:8080/actuator/health"
STATUS=$(curl -s -o /dev/null -w "%{http_code}" $URL)
if [$STATUS -eq 200]; then
  echo "Application is healthy"
else
  echo "Application is not healthy. Status code: $STATUS"
fi
