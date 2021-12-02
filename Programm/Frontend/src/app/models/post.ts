import { Comment } from "./comment";
import { Picture } from "./picture";

export class Post {
    postId: number;
    title: string;
    text: string;
    isConcert: boolean;
    createdAt: Date; 
    pictures: Picture[];
    comments: Comment[];
}