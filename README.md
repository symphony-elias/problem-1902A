# Description
This is an attempt to solve this problem: https://codeforces.com/problemset/problem/1902/A

The [Main.java](./src/main/java/org/ecroze/Main.java) file was successfully submitted to codeforces without the
`package` statement.

# Rationale of implementation

The outcome of the insert operation relies on the values of current and next characters. The four cases are:
* `00` -> `010`
* `01` -> `001`
* `10` -> `100`
* `11` -> `111`

Since we want to have more zeroes than ones, we are only interested in inserting zeroes, which means patterns
`01` and `10` are interesting for us. Please note that, for both patterns, we can repeat the insert operation as
many times as we want so that we have more zeroes than ones at the end.

We are left with the following cases:
* If the string only have ones, we cannot insert zeroes. Answer is `NO`.
* If the string contains at least one zero, either it is `0`: answer is `YES`, or it contains patterns `01` or `10`. We repeat the insert operation until we have enough zeroes.

Therefore, answer is `YES` if and only if input string contains at least one `0` character.
