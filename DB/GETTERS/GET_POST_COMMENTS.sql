USE DALTONS;

SELECT * FROM POST
JOIN COMMENT
ON COMMENT.POST_ID = POST.POST_ID