package com.axzo.sample.domain.shared.specification;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public abstract class  AbstractSpecification<T> implements Specification<T> {

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract boolean isSatisfiedBy(T t);

  /**
   * {@inheritDoc}
   */
  @Override
  public Specification<T> and(final Specification<T> specification) {
    return new AndSpecification<T>(this, specification);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Specification<T> or(final Specification<T> specification) {
    return new OrSpecification<T>(this, specification);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Specification<T> not(final Specification<T> specification) {
    return new NotSpecification<T>(specification);
  }
}
