import { comment } from "./comment";
import { picture } from "./picture";
import { user } from "./user";

export interface post{
    postId: number;
    title: string;
    text: string;
    isConcert: boolean;
    createdAt: Date; 
    pictures: picture[];
    comments: comment[];
}