<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# RIFE2 Changelog

## [Unreleased]

- RIFE2 template file types are now only activated when they're found inside a `templates` directory.
- Updated to latest IntelliJ Platform Plugin Template v2.0.0-rc2.

## [0.7.0] - 2024-06-23

- Improved template parsing for the updated lexer in RIFE2-core.
- Added support for IDEA 2024.2.
- Updated to latest IntelliJ Platform Plugin Template v1.14.1.

## [0.6.1] - 2024-04-21

- Added support for IDEA 2024.1.
- Updated to latest IntelliJ Platform Plugin Template v1.13.0.

## [0.6.0] - 2023-12-09

- Added support for IDEA 2023.3.
- Updated to latest IntelliJ Platform Plugin Template v1.11.3.

## [0.5.9] - 2023-07-28

- Added support for IDEA 2023.2.
- Updated to latest IntelliJ Platform Plugin Template v1.9.0.

## [0.5.8] - 2023-03-29

- Fixed exception with IDEA 2023.1.

## [0.5.7] - 2023-03-16

- Removed auto-template tag closing while typing since it could be frustrating and live template are more convenient.
- Updated to intellij-platform-plugin v1.5.0.

## [0.5.6] - 2023-03-12

- Fixed initialization problems with recent versions of IDEA Community edition.
- Fixed deprecated API usages.

## [0.5.5] - 2023-03-12

- Minor bug fixes

## [0.5.4] - 2023-03-01

- Added support for ^ characters in template tag names.

## [0.5.3] - 2023-02-15

- Added file template support for Element, Router and Site creation.
- Added Java live templates for common routing idioms.
- Added template engine live templates for tag creation and surrounding.

## [0.5.2] - 2023-02-04

- Fixed formatting of templated language not behaving correctly.

## [0.5.1] - 2023-01-30

- Improvements to plugin description for the JetBrains marketplace.

## [0.5.0] - 2023-01-29

- Initial release of RIFE2 IntelliJ Plugin
- Supports HTML, JSON, SVG, TXT and XML template language highlighting with fallback to original languages.
- Filtered value tags auto-completion to all template types.
- Syntax highlighting color settings configuration panel.
- Auto-tag closing characters addition when typing `{` or `<!`.
- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)

[Unreleased]: https://github.com/rife2/rife2-idea/compare/v0.7.0...HEAD
[0.7.0]: https://github.com/rife2/rife2-idea/compare/v0.6.1...v0.7.0
[0.6.1]: https://github.com/rife2/rife2-idea/compare/v0.6.0...v0.6.1
[0.6.0]: https://github.com/rife2/rife2-idea/compare/v0.5.9...v0.6.0
[0.5.9]: https://github.com/rife2/rife2-idea/compare/v0.5.8...v0.5.9
[0.5.8]: https://github.com/rife2/rife2-idea/compare/v0.5.7...v0.5.8
[0.5.7]: https://github.com/rife2/rife2-idea/compare/v0.5.6...v0.5.7
[0.5.6]: https://github.com/rife2/rife2-idea/compare/v0.5.5...v0.5.6
[0.5.5]: https://github.com/rife2/rife2-idea/compare/v0.5.4...v0.5.5
[0.5.4]: https://github.com/gbevin/rife2-idea/compare/v0.5.3...v0.5.4
[0.5.3]: https://github.com/gbevin/rife2-idea/compare/v0.5.2...v0.5.3
[0.5.2]: https://github.com/gbevin/rife2-idea/compare/v0.5.1...v0.5.2
[0.5.1]: https://github.com/gbevin/rife2-idea/compare/v0.5.0...v0.5.1
[0.5.0]: https://github.com/gbevin/rife2-idea/commits/v0.5.0
