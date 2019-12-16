import {Request, Response} from "express";

export default interface IBaseController {
    initRoutes(res: Response): any;
    getAll(res: Response): [];
    getById(req: Request, res: Response): any;
    insert(req: Request, res: Response): any;
    update(req: Request, data: any, res: Response): any;
    delete(req: Request, res: Response): any;
}
