import { Response } from "express";
import Blog from "../entity/blog.entity";

export default class BlogRepository {

    public async getEmployeeBlogs(employeeId: number, res: Response) {
        Blog.findAll({
            "where": {
                "employeeId": employeeId
            }
        })
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }

    public async getAll(res: Response) {
        Blog.findAll()
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }

    public async addBlog(data: any, res: Response) {
        Blog.create(data).then((result) => {
            res.send(result);
        }).catch((err) => { res.send(err); });
    }

    public async deleteBlog(id: number, res: Response) {
        Blog.destroy({
            "where": {
                "id": id
            }
        }).then((result) => {
            res.send(result);
        }).catch((err) => { res.send(err); });
    }
}
