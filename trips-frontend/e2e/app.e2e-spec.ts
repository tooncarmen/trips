import { TripsFrontendPage } from './app.po';

describe('trips-frontend App', () => {
  let page: TripsFrontendPage;

  beforeEach(() => {
    page = new TripsFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
