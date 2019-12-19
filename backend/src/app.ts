import express from "express";
import { Application } from "express";
import { sequelize } from "./sequelize";

export default class App {
    public app: Application;
    public port: number;

    constructor(appInit: {
        port: number,
        middleWares: any,
        controller: any
    }) {
        this.app = express();
        this.port = appInit.port;

        sequelize.sync({ "force": false });

        this.middlewares(appInit.middleWares);

        this.routes(appInit.controller);
    }

    public listen() {
        this.app.listen(this.port, () => {
            console.log(`App listening on the http://localhost:${this.port}`);
        });
    }

    private middlewares(middleWares: { forEach: (arg0: (middleWare: any) => void) => void; }) {
        middleWares.forEach((middleWare) => {
            this.app.use(middleWare);
        });
    }

    private routes(controllers: { forEach: (arg0: (controller: any) => void) => void; }) {
        controllers.forEach((controller) => {
            this.app.use("/api", controller.router);
        });
    }
}
