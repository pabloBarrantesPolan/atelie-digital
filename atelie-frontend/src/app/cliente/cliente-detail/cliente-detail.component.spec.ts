import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteDetailComponent } from './cliente-detail.component';

describe('ClienteDetailComponent', () => {
  let component: ClienteDetailComponent;
  let fixture: ComponentFixture<ClienteDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClienteDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClienteDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
