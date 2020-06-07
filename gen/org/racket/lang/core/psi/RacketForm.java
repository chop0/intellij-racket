// This is a generated file. Not intended for manual editing.
package org.racket.lang.core.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface RacketForm extends RacketElement {

  @Nullable
  RacketDatum getDatum();

  @NotNull
  List<RacketForm> getFormList();

}
