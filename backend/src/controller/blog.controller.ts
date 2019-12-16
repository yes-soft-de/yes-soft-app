import * as express from "express";
import { Request, Response } from "express";
import BlogManager from "../manager/blog.manager";

export default class BlogController {
    public path = "/blog";
    public router = express.Router();

    private blogManager: BlogManager;

    constructor() {
        this.router.get(`${this.path}`, (req, res) => { this.getAll(res); });
        this.router.get(`${this.path}/:employee_id`, (req, res) => {
            this.getEmployeeBlogs(req, res);
        });
        this.router.delete(`${this.path}/:id`, (req, res) => { this.deleteBlog(req, res); });
        this.router.post(`${this.path}`, (req, res) => { this.addBlog(req, res); });
        this.blogManager = new BlogManager();
    }

    public getAll(res: Response) {
        this.blogManager.getAll(res);
    }

    public getEmployeeBlogs(req: Request, res: Response) {
        this.blogManager.getEmployeeBlogs(req, res);
    }

    public addBlog(req: Request, res: Response) {
        this.blogManager.addBlog(req, res);
    }

    public deleteBlog(req: Request, res: Response) {
        this.blogManager.deleteBlog(req, res);
    }
}
