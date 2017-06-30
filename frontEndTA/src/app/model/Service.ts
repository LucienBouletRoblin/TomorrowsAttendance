export class Service {
    public attendance: number;
    public date: Date;
    public number: number;
  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
