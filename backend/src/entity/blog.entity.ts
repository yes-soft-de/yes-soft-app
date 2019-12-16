import { Column, CreatedAt, HasMany, Model, Table, UpdatedAt } from "sequelize-typescript";

export default class Blog extends Model<Blog> {
    @Column
    public title: string;

    @Column
    public date: string;

    @Column
    public link: string;

    @Column
    public employeeId: string;

    @CreatedAt
    @Column
    public createdAt!: Date;

    @UpdatedAt
    @Column
    public updatedAt!: Date;
}
