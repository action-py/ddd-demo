package com.axzo.sample.domain.shared.specification;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public class OrSpecification<T> extends AbstractSpecification<T> {

  private Specification<T> spec1;
  private Specification<T> spec2;

  /**
   * Create a new OR specification based on two other spec.
   *
   * @param spec1 Specification one.
   * @param spec2 Specification two.
   */
  public OrSpecification(final Specification<T> spec1, final Specification<T> spec2) {
    this.spec1 = spec1;
    this.spec2 = spec2;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isSatisfiedBy(final T t) {
    return spec1.isSatisfiedBy(t) || spec2.isSatisfiedBy(t);
  }
}
