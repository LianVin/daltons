import { Post } from "./post";

export class Comment{
    commentId: number;
    text: string;
    createdAt: Date;
    postId: Post;
}