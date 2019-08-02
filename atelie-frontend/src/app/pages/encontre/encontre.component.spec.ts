import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EncontreComponent } from './encontre.component';

describe('EncontreComponent', () => {
  let component: EncontreComponent;
  let fixture: ComponentFixture<EncontreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EncontreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EncontreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
