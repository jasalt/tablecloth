(ns tablecloth.column.api
  ;;Autogenerated from tablecloth.column.api.api-template-- DO NOT EDIT
  "Tablecloth Column API"
  (:require [tablecloth.column.api.api-template]
            [tablecloth.column.api.column]
            [tablecloth.column.api.missing]
            [tech.v3.dataset.column]))

(defn column
  "Create a `column` from a vector or sequence. "
  ([]
  (tablecloth.column.api.column/column ))
  ([data]
  (tablecloth.column.api.column/column data))
  ([data options]
  (tablecloth.column.api.column/column data options)))


(defn column-map
  "Applies a map function `map-fn` to one or more columns. If `col` is
  a vector of columns, `map-fn` must have an arity equal to the number
  of columns. The datatype of the resulting column will be inferred,
  unless specified in the `options` map. Missing values can be handled
  by providing a `:missing-fn` in the options map.

  options:
  - :datatype   - The desired datatype of the resulting column. The datatype
                  is inferred if not provided
  - :missing-fn - A function that takes a sequence of columns, and returns a
                  set of missing index positions."
  ([col map-fn]
  (tablecloth.column.api.column/column-map col map-fn))
  ([col map-fn options]
  (tablecloth.column.api.column/column-map col map-fn options)))


(defn column?
  "Return true or false `item` is a column."
  ([item]
  (tablecloth.column.api.column/column? item)))


(defn count-missing
  "Returns the number of missing values in column `col`. "
  ([col]
  (tablecloth.column.api.missing/count-missing col)))


(defn drop-missing
  "Remove missing values from column `col`."
  ([col]
  (tablecloth.column.api.missing/drop-missing col)))


(defn is-missing?
  "Return true if this index is missing."
  ([col idx]
  (tech.v3.dataset.column/is-missing? col idx)))


(defn missing
  "Indexes of missing values.  Both iterable and reader."
  (^{:tag org.roaringbitmap.RoaringBitmap} [col]
  (tech.v3.dataset.column/missing col)))


(defn ones
  "Creates a new column filled with `n-ones`"
  ([n-ones]
  (tablecloth.column.api.column/ones n-ones)))


(defn replace-missing
  "Replace missing values in column `col` with give `strategy`.

    Strategies may be:

    - `:down` -	Take the previous value, or use provided value.
    - `:up` - Take the next value, or use provided value.
    - `:downup` - Take the previous value, otherwise take the next value.
    - `:updown` - Take the next value, otherwise take the previous value.
    - `:nearest` - Use the nearest of next or previous values. (Strategy `:mid` is an alias for `:nearest`).
    - `:midpoint` - Use the midpoint of averaged values between previous and next (non-missing) values.
    - `:abb` - Impute missing value with approximate Bayesian bootstrap.
               See [r's ABB](https://search.r-project.org/CRAN/refmans/LaplacesDemon/html/ABB.html).
    - `:lerp` - Linearly interpolate values between previous and next nonmissing rows.
    - `:value` - Provide a value explicitly.  Value may be a function in which
                 case it will be called on the column with missing values elided
                 and the return will be used to as the filler."
  ([col]
  (tablecloth.column.api.missing/replace-missing col))
  ([col strategy]
  (tablecloth.column.api.missing/replace-missing col strategy))
  ([col strategy value]
  (tablecloth.column.api.missing/replace-missing col strategy value)))


(defn select
  "Return a new column with the subset of indexes based on the provided `selection`.
  `selection` can be a list of indexes to select or boolean values where the index
  position of each true element indicates a index to select. When supplying a list
  of indices, duplicates are possible and will select the specified position more
  than once."
  ([col selection]
  (tech.v3.dataset.column/select col selection)))


(defn slice
  "Returns a subset of the column defined by the inclusive `from` and
  `to` indexes. If `to` is not provided, slices to the end of the
  column. If `from` is not provided (i.e. is `nil`), slices from the
  beginning of the column. If either `from` or `to` is a negative
  number, it is treated as an index from the end of the column. The
  `:start` and `:end` keywords can be used to represent the start and
  end of the column, respectively.

  Examples:
  (def column [1 2 3 4 5])
  (slice column 1 3)     ;=> [2 3]
  (slice column 2)        ;=> [3 4 5]
  (slice column -3 -1)    ;=> [3 4 5]
  (slice column :start 2) ;=> [1 2 3 4 5]
  (slice column 2 :end)   ;=> [3 4 5]
  (slice column -2 :end)  ;=> [4 5]"
  ([col from]
  (tablecloth.column.api.column/slice col from))
  ([col from to]
  (tablecloth.column.api.column/slice col from to))
  ([col from to step]
  (tablecloth.column.api.column/slice col from to step)))


(defn sort-column
  "Returns a sorted version of the column `col`. You can supply the ordering
  keywords `:asc` or `:desc` or a comparator function to `order-or-comparator`.
  If no comparator function is provided, the column will be sorted in
  ascending order."
  ([col]
  (tablecloth.column.api.column/sort-column col))
  ([col order-or-comparator]
  (tablecloth.column.api.column/sort-column col order-or-comparator)))


(defn typeof
  "Returns the concrete type of the elements within the column `col`."
  ([col]
  (tablecloth.column.api.column/typeof col)))


(defn typeof?
  "True|false the column's elements are of the provided type `datatype`. Can check
   both concrete types (e.g. :int32) or general types (:numerical, :textual, etc)."
  ([col datatype]
  (tablecloth.column.api.column/typeof? col datatype)))


(defn zeros
  "Create a new column filled wth `n-zeros`."
  ([n-zeros]
  (tablecloth.column.api.column/zeros n-zeros)))


