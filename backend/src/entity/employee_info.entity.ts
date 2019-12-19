import { Column, CreatedAt, HasMany, Model, Table, UpdatedAt } from "sequelize-typescript";

@Table
export default class EmployeeInfoEntity extends Model<EmployeeInfoEntity> {

    @Column
    public name: string;
    @Column
    public age: string;
    @Column
    public quote: string;
    @Column
    public position: string;
    @Column
    public image: string;
    @Column
    public linkedin?: string;
    @Column
    public facebook?: string;
    @Column
    public twitter?: string;
    @Column
    public github?: string;
    @Column
    public email?: string;

    @CreatedAt
    @Column
    public createdAt!: Date;

    @UpdatedAt
    @Column
    public updatedAt!: Date;
}
