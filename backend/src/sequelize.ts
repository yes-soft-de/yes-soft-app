import { Sequelize } from "sequelize-typescript";

export const sequelize = new Sequelize({
    "dialect": "sqlite",
    "database": "yes-soft",
    "storage": "yes-soft.db",
    "models": [__dirname + "/entity"]
});
