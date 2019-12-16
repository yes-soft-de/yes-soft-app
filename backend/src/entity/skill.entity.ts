import { Column, CreatedAt, HasMany, Model, Table, UpdatedAt } from "sequelize-typescript";

export default class Skill extends Model<Skill> {
    @Column
    public skill: string;

    @Column
    public employeeId: string;

    @CreatedAt
    @Column
    public createdAt!: Date;

    @UpdatedAt
    @Column
    public updatedAt!: Date;
}
