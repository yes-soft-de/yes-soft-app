import { Request, Response } from "express";
import BlogRepository from "../repository/blog.repo";

export default class BlogManager {
    private blogRepo: BlogRepository;

    constructor() {
        this.blogRepo = new BlogRepository();
    }

    public getAll(res: Response) {
        this.blogRepo.getAll(res);
    }

    public getEmployeeBlogs(req: Request, res: Response) {
        this.blogRepo.getEmployeeBlogs(+req.params.employee_id, res);
    }

    public addBlog(req: Request, res: Response) {
        this.blogRepo.addBlog(req.body, res);
    }

    public deleteBlog(req: Request, res: Response) {
        this.blogRepo.deleteBlog(+req.params.id, res);
    }
}
