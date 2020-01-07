export class ServiceFlatNode {
  constructor(public expandable: boolean,
              public serviceName: string,
              public level: number,
              public type: any) {
  }
}
