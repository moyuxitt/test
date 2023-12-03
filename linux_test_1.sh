#!/bin/bash

# 参数检查
if [ $# -ne 3 ]; then
  echo "Usage: $0 file pattern output"
  exit 1
fi

# 赋值变量
file=$1
pattern=$2
output=$3

# 搜索文件中的指定内容，并将结果保存到新文件中
grep -n "$pattern" "$file" > "$output"

# 输出结果到控制台
cat "$output"
