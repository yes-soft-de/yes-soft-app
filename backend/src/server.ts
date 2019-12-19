import App from "./app";

import * as bodyParser from "body-parser";
import BlogController from "./controller/blog.controller";
import EmployeeController from "./controller/employee.controller";
import ProjectController from "./controller/project.controller";
import SkillController from "./controller/skill.controller";
import corsMiddleware from "./middleware/cors";
import loggerMiddleware from "./middleware/logger";

const app = new App(
    {
        "port": 3000,

        "middleWares": [
            bodyParser.json(),
            
            bodyParser.urlencoded({ "extended": true }),
            loggerMiddleware,
            corsMiddleware
        ],
        "controller": [
            new EmployeeController(),
            new ProjectController(),
            new BlogController(),
            new SkillController()
        ]
    }
);

app.listen();
