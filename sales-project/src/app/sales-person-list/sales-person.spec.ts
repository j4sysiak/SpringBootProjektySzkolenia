import { SalesPerson } from './sales-person';

describe('SalesPerson', () => {
  it('should create an instance', () => {
    expect(new SalesPerson("firstName", "lastName", "email", 1)).toBeTruthy();
  });
});
