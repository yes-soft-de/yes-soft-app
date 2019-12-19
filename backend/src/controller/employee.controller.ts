import * as express from "express";
import { Request, Response } from "express";
import EmployeeManager from "../manager/employee.manager";
import IBaseController from "./base_controller.interface";

export default class EmployeeController implements IBaseController {
    public path = "/employee";
    public router = express.Router();

    public employeeManager: EmployeeManager;

    constructor() {
        this.employeeManager = new EmployeeManager();
        this.router.get(this.path, (req, res: Response) => { this.getAll(res); });
        this.router.get(`${this.path}/:id`, (req, res: Response) => { this.getById(req, res); });
        this.router.post(this.path, (req: Request, res: Response) => { this.insert(req, res); });
    }

    public getAll(res: Response): any {
        this.employeeManager.getAll(res);
    }

    public getById(req: Request, res: Response): any {
        this.employeeManager.getById(req, res);
    }

    public insert(req: Request, res: Response): any {
        this.employeeManager.insert(req, res);
    }

    public delete(req: Request, res: Response): any {
        return null;
    }

    public update(req: Request, data: any, res: Response): any {
        return null;
    }

    public initRoutes(res: Response): any {
        return null;
    }
}
