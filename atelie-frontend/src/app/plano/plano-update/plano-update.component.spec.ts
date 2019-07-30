import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanoUpdateComponent } from './plano-update.component';

describe('PlanoUpdateComponent', () => {
  let component: PlanoUpdateComponent;
  let fixture: ComponentFixture<PlanoUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanoUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
