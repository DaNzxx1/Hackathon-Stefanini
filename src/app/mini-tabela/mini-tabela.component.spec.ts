import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiniTabelaComponent } from './mini-tabela.component';

describe('MiniTabelaComponent', () => {
  let component: MiniTabelaComponent;
  let fixture: ComponentFixture<MiniTabelaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiniTabelaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MiniTabelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
