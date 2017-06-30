export class Service {
    public attendance: number;
    public date: Date;
    public number = '1';
  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
