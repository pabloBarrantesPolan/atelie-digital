import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpresaCreateComponent } from './empresa-create.component';

describe('EmpresaCreateComponent', () => {
  let component: EmpresaCreateComponent;
  let fixture: ComponentFixture<EmpresaCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpresaCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpresaCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
